package com.establish.the.run.client.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration @RequiredArgsConstructor @Slf4j
public class WebClientConfig implements WebFluxConfigurer {

    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    @Bean
    @LoadBalanced
    public WebClient getWebClient() {
        return WebClient.builder().filter(lbFunction)
/*                .exchangeStrategies(ExchangeStrategies.builder().codecs(
                                clientCodecConfigurer ->
                                        clientCodecConfigurer.defaultCodecs().maxInMemorySize(1000000000))
                        .build())*/
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }

/*    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        configurer.defaultCodecs().maxInMemorySize(5 * 1024 * 1024);
    }*/

    private ExchangeFilterFunction logRequest() {
        return (clientRequest, next) -> {
            log.debug("Request: {} {}", clientRequest.method(), clientRequest.url());
            return next.exchange(clientRequest);
        };
    }

    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            log.debug("Response Status: {}", clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }
}
