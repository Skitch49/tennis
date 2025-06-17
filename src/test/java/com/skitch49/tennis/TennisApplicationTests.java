package com.skitch49.tennis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.skitch49.tennis.repository.HealthCheckRepository;
import com.skitch49.tennis.rest.HealthCheckController;
import com.skitch49.tennis.service.HealthCheckService;

@SpringBootTest
class TennisApplicationTests {

	@Autowired
	private HealthCheckController healthCheckController;
	@Autowired
	private HealthCheckRepository healthCheckRepository;
	@Autowired
	private HealthCheckService healthCheckService;

	@Test
	void contextLoads() {
		Assertions.assertThat(healthCheckController).isNotNull();
		Assertions.assertThat(healthCheckRepository).isNotNull();
		Assertions.assertThat(healthCheckService).isNotNull();
	}

}
