package br.com.rodrigodonizettio.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/config")
public class ExternalizedConfigExampleResource {

    @ConfigProperty(defaultValue = "NotFound", name = "external-config")
    String externalConfig;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String externalConfig() {
        return String.format("The 'external-config' key-property has value: %s", externalConfig);
    }
}