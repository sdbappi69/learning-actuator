package com.learining.actuator.api.service;

import com.learining.actuator.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStatusCountContributor implements InfoContributor {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> userStatusCount = new HashMap<>();
        userStatusCount.put("Active", userRepository.getTotalUsersByStatus("Active"));
        userStatusCount.put("Inactive", userRepository.getTotalUsersByStatus("Inactive"));
        builder.withDetail("userStatusCount", userStatusCount);
    }
}
