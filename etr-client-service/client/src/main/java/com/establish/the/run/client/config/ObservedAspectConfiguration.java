package com.establish.the.run.client.config;

import com.establish.the.run.client.log.LoggingHandler;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObservedAspectConfiguration {

    @Bean
    public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        observationRegistry.observationConfig().observationHandler(new LoggingHandler());

        return new ObservedAspect(observationRegistry);
    }
}