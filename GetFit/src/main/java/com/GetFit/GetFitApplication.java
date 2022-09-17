package com.GetFit;
import com.GetFit.dal.Macros;
import com.GetFit.models.Macro;
import com.GetFit.resources.MacroResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class GetFitApplication extends Application<GetFitConfiguration> {

    private final HibernateBundle<GetFitConfiguration> hibernate = new HibernateBundle<GetFitConfiguration>(Macro.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(GetFitConfiguration getFitConfiguration) {
            return GetFitConfiguration.getDataSourceFactory();
        }
    };
    public static void main(final String[] args) throws Exception {
        new GetFitApplication().run(args);
    }

    @Override
    public String getName() {
        return "GetFit";
    }

    @Override
    public void initialize(final Bootstrap<GetFitConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final GetFitConfiguration configuration,
                    final Environment environment) {
        final Macros macro = new Macros(hibernate.getSessionFactory());
        environment.jersey().register(new MacroResource(macro));
    }

}
