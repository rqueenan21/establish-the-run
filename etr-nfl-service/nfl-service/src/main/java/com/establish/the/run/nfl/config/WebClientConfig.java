package com.establish.the.run.nfl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig implements WebFluxConfigurer {

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                                clientCodecConfigurer ->
                                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(1000000000))
                        .build())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        configurer.defaultCodecs().maxInMemorySize(5 * 1024 * 1024);
    }
}
