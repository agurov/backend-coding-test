package com.alchemytec.codingtest;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import resources.ExpensesResource;

public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfiguration config, Environment env) throws Exception {
        env.jersey().register(new ExpensesResource());
    }
}
