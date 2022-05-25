package br.com.rodrigodonizettio.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

@Readiness
public class ReadinessProbeExampleResource implements HealthCheck {
    @ConfigProperty(defaultValue = "https://github.com/rodrigodonizettio", name = "healthcheck.readiness.endpoint")
    String readinessTargetUrl;

    @Override
    public HealthCheckResponse call() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(readinessTargetUrl).request().get();

        if(200 == response.getStatus()) {
            return HealthCheckResponse.up("myAppNameReadiness");
        }
        return HealthCheckResponse.down("myAppNameReadiness");
    }
}
