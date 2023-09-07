package com.learining.actuator.api.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
public class InternetHealthMetrics implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        Map<String, String> details = new HashMap<>();
        if (checkInternet()) {
            details.put("internetStatus", "Active Internet Connection");
            return Health.up().withDetails(details).build();
        } else {
            details.put("internetStatus", "Inactive Internet Connection");
            return Health.down().withDetails(details).build();
        }
    }

    private boolean checkInternet() {
        Boolean flag = false;
        try {
             URL url = new URL("http://www.google.com");
             HttpURLConnection con = (HttpURLConnection) url.openConnection();
             con.connect();
             if (con.getResponseCode() == 200) {
                 flag = true;
             }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
