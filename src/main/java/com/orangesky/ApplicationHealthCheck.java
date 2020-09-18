package com.orangesky;

import com.codahale.metrics.health.HealthCheck;

public class ApplicationHealthCheck extends HealthCheck {
  private static final String HEALTHY = "The Orange Sky Application is healthy ";
  private static final String UNHEALTHY = "The Orange Sky Application is not healthy. ";
  


  @Override
  public Result check() throws Exception {
    return  Result.healthy(HEALTHY);
  }
}