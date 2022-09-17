import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import metrics.healths.HealthCheck;
import resources.MacroResource;

public class GetFitAPIApplication extends Application<GetFitAPIConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GetFitAPIApplication().run(args);
    }

    @Override
    public String getName() {
        return "GetFit";
    }

    @Override
    public void initialize(final Bootstrap<GetFitAPIConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final GetFitAPIConfiguration configuration,
                    final Environment environment) {
        final MacroResource macroResource = new MacroResource(configuration.getProtein(), configuration.getCarbs(), configuration.getFats());
        final HealthCheck healthCheck = new HealthCheck(configuration.getProtein(), configuration.getCarbs(), configuration.getFats());
        environment.jersey().register(macroResource);
        environment.jersey().register(healthCheck);
    }

}
