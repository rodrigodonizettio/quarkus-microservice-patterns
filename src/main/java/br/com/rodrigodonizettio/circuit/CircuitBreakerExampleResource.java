package br.com.rodrigodonizettio.circuit;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Path("/circuit")
public class CircuitBreakerExampleResource {
    @Timeout(unit = ChronoUnit.MILLIS, value = 1000)
    @Fallback(fallbackMethod = "circuitFallback")
    @CircuitBreaker(requestVolumeThreshold = 3, failureRatio = 0.65, delay = 3000L, successThreshold = 3)

    @Path("{sleepTime}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String circuitBreaker(long sleepTime) throws InterruptedException {
        Thread.sleep(sleepTime);
        return "Everything is ok!";
    }

    private String circuitFallback(long sleepTime) {
        return String.format("'circuitFallback' method called at: %s when 'sleepTime is: %d'", Instant.now(), sleepTime);
    }
}
