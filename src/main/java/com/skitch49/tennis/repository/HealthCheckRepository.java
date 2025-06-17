package com.skitch49.tennis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class HealthCheckRepository {

    @Autowired
    private EntityManager entityManager;

    public long countApplicationConnections() {
        String applicationConnectionsQuery = "select count(*) from pg_stat_activity where application_name = 'PostgreSQL JDBC Driver'";
        return (Long) entityManager.createNativeQuery(applicationConnectionsQuery).getSingleResult();
    }
}
