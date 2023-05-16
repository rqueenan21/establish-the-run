package com.establish.the.run.client.service;

import com.establish.the.run.client.exceptions.JobCreationException;
import com.establish.the.run.client.exceptions.SleeperLeagueException;
import com.establish.the.run.client.model.sleeper.SleeperLeague;
import com.establish.the.run.client.model.sleeper.SleeperUser;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service @RequiredArgsConstructor @Slf4j
public class EtrNflServiceImpl implements EtrNflService{

    private final WebClient webClient;

    @Override
    @Retry(name = "nflService")
    @CircuitBreaker(name = "nflService")
    @TimeLimiter(name = "nflService")
    @RateLimiter(name = "nflService")
    public Flux<SleeperLeague> getLeaguesByUser(String userId) {
        log.info("Calling for user {} " + userId);
        return webClient.get().uri("http://ETR-NFL/sleeper/leagues/{userId}", userId)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> {
                    log.error("Error retrieving sleeper leagues for user id {} with status code {}", userId, clientResponse.statusCode());
                    throw new SleeperLeagueException("Error creating calling ETR NFL Service for Sleeper Leagues");
                })
                .bodyToFlux(SleeperLeague.class);
    }
}
