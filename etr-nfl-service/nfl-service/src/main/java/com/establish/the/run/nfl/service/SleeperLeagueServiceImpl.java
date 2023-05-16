package com.establish.the.run.nfl.service;

import com.establish.the.run.nfl.model.sleeper.SleeperLeague;
import com.establish.the.run.nfl.model.sleeper.dto.SleeperLeagueDto;
import com.establish.the.run.nfl.model.sleeper.dto.SleeperLeagueDtoMapper;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.reactor.ratelimiter.operator.RateLimiterOperator;
import io.github.resilience4j.reactor.retry.RetryOperator;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service @RequiredArgsConstructor @Slf4j
public class SleeperLeagueServiceImpl implements SleeperLeagueService{

    private final WebClient webClient;
    private final RateLimiterRegistry rateLimiterRegistry;
    private final RetryRegistry retryRegistry;
    private final SleeperLeagueDtoMapper leagueDtoMapper;
    @Override
    public Flux<SleeperLeagueDto> getSleeperLeaguesByUser(String userId){
        Flux<Integer> seasons = Flux.range(2017,7);
        log.info("Calling sleeper league for user id {}", userId);
        return seasons.flatMap(season -> callSleeperLeaguesApi(userId, season))
                .transformDeferred(RateLimiterOperator.of(rateLimiterRegistry.rateLimiter("sleeperRateLimiter")))
                .transformDeferred(RetryOperator.of(retryRegistry.retry("sleeperRetryConfig")));
    }

    private Flux<SleeperLeagueDto> callSleeperLeaguesApi(String userId, Integer season){
        Flux<SleeperLeague> leagues =  webClient.get()
                .uri("https://api.sleeper.app/v1/user/{userId}/leagues/nfl/{season}", userId, season)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> {
                    log.error("Error getting sleeper leagues for user {}, season {}, with status code {}",
                            userId, season, clientResponse.statusCode());
                    throw new RuntimeException("Error while calling leagues endpoint");
                })
                .bodyToFlux(SleeperLeague.class)
                .timeout(Duration.ofSeconds(30));

        Flux<SleeperLeagueDto> leagueDtoFlux = leagues.map(league -> leagueDtoMapper.sleeperLeagueMapper(league));
        return leagueDtoFlux;
    }

}
