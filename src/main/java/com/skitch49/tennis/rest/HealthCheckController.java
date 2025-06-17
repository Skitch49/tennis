package com.skitch49.tennis.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skitch49.tennis.HealthCheck;
import com.skitch49.tennis.service.HealthCheckService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="HealthCheck API")
@RestController
public class HealthCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @Operation(summary = "Returns application status",description = "Return the application status")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",description = "Healthchek status with some details",content = {@Content(mediaType = "application/json",
        schema = @Schema(implementation = HealthCheck.class))})
    })
    @GetMapping("/healthcheck")
    public HealthCheck healthCheck() {
        return healthCheckService.healthCheck();
    }
}
