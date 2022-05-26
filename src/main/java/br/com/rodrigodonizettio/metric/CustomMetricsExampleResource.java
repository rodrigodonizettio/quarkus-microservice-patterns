package br.com.rodrigodonizettio.metric;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/custom-metrics")
public class CustomMetricsExampleResource {
    @Counted(name = "myCounted", description = "myCounted description")
    @Path("counted")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String counted() {
        return "myCounted";
    }

    @Timed(name = "myTimed", description = "myTimed description")
    @Path("timed")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String timed() {
        return "myTimed";
    }
}
