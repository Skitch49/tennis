package com.skitch49.tennis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skitch49.tennis.ApplicationStatus;
import com.skitch49.tennis.HealthCheck;
import com.skitch49.tennis.repository.HealthCheckRepository;

@Service
public class HealthCheckService {

    @Autowired
    private HealthCheckRepository healthCheckRepository;

    public HealthCheck healthCheck() {
        Long activeSessions = healthCheckRepository.countApplicationConnections();

        if (activeSessions >= 1) {
            return new HealthCheck(ApplicationStatus.OK, "Welcome to Skitch Tennis !");

        } else {
            return new HealthCheck(ApplicationStatus.KO, "Fail connection !");

        }

    }
}
