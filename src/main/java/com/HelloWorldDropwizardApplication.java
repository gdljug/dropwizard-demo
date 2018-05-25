package com;

import com.core.entity.Person;
import com.core.service.ServiceModule;
import com.db.dao.DaoModule;
import com.db.dao.PersonDao;
import com.resources.HelloWorldDropwizardResource;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldDropwizardApplication extends Application<HelloWorldDropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWorldDropwizardApplication().run(args);
    }

    private final HibernateBundle<HelloWorldDropwizardConfiguration> hibernateBundle =
            new HibernateBundle<HelloWorldDropwizardConfiguration>(Person.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(HelloWorldDropwizardConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };


    @Override
    public String getName() {
        return "HelloWorldDropwizard";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldDropwizardConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new MigrationsBundle<HelloWorldDropwizardConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(HelloWorldDropwizardConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final HelloWorldDropwizardConfiguration configuration,
                    final Environment environment) {
        final PersonDao dao = new PersonDao(hibernateBundle.getSessionFactory());
        environment.jersey().register(HelloWorldDropwizardResource.class);
        environment.jersey().register(new ServiceModule());
        environment.jersey().register(new DaoModule(dao));


    }

}
