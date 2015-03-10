package com.alchemytec.codingtest;

import com.alchemytec.codingtest.db.ExpenseDAO;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import resources.ExpenseResource;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
    }

    @Override
    public void run(AppConfiguration config, Environment env) throws Exception {
        // init db
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(env, config.getDataSourceFactory(), "postgresql");

        final ExpenseDAO expenseDao = jdbi.onDemand(ExpenseDAO.class);
        expenseDao.createTableIfNeeded();

        // init resource handlers
        env.jersey().register(new ExpenseResource(expenseDao));
    }
}
