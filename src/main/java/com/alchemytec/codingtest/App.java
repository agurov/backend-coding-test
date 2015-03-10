package com.alchemytec.codingtest;

import com.alchemytec.codingtest.db.ExpenseDAO;
import com.alchemytec.codingtest.resources.ExpenseResource;
import com.google.common.base.Charsets;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.servlets.assets.AssetServlet;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.skife.jdbi.v2.DBI;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfiguration config, Environment env) throws Exception {
        // init db
        DBIFactory factory = new DBIFactory();
        DBI jdbi = factory.build(env, config.getDataSourceFactory(), "postgresql");

        ExpenseDAO expenseDao = jdbi.onDemand(ExpenseDAO.class);
        expenseDao.createTableIfNeeded();

        // init resource handlers
        env.jersey().register(new ExpenseResource(expenseDao));
        if (System.getProperty("devMode") != null) {
            env.servlets().setResourceBase("src/main/resources/assets");
            env.servlets().addServlet("resourceServlet", new DefaultServlet()).addMapping("/");
        } else {
            env.servlets().addServlet("assets", new AssetServlet("/assets/", "/", "index.html", Charsets.UTF_8)).addMapping("/");
        }
    }
}
