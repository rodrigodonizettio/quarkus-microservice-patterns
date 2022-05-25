package br.com.rodrigodonizettio.profile;

import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Map;

public class UnhealthyTestProfile implements QuarkusTestProfile {
    @Override
    public Map<String, String> getConfigOverrides() {
        return Map.of("healthcheck.readiness.endpoint", "https://github.com/rodrigodonizettio123");
    }
}
