package com.establish.the.run.client.service;

import com.establish.the.run.client.exceptions.JobCreationException;
import com.establish.the.run.client.exceptions.SleeperLeagueException;
import com.establish.the.run.client.exceptions.SleeperUsersException;
import com.establish.the.run.client.model.sleeper.SleeperLeague;
import com.establish.the.run.client.model.sleeper.SleeperUser;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service @RequiredArgsConstructor @Slf4j
public class EtrDataServiceImpl implements EtrDataService {

    private final WebClient webClient;

    @Override
    @Retry(name = "dataService")
    @CircuitBreaker(name = "dataService")
    public Flux<SleeperUser> getAllSleeperUsers() {
        return webClient.get().uri("http://ETR-NFL-DATA/sleeper/users")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> {
                    log.error("Error retrieving all sleeper users from nfl data service with status of {}", clientResponse.statusCode());
                    throw new SleeperUsersException("Error getting users");
                })
                .bodyToFlux(SleeperUser.class);
    }

    @Override
    @Retry(name = "dataService")
    @CircuitBreaker(name = "dataService")
    public Mono<SleeperLeague> addSleeperLeague(SleeperLeague league) {
        return webClient.post().uri("http://ETR-NFL-DATA/sleeper/leagues")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(league))
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> {
                    log.error("Error updating league {}, with status of {}", league.getLeagueId(), clientResponse.statusCode());
                    throw new SleeperLeagueException("Error inserting league");
                })
                .bodyToMono(SleeperLeague.class);
    }

    public Flux<SleeperUser> fallbackSleeperUsers(Throwable ex){
        log.error("Error getting users, falling back to default behavior. Error {}", ex.getMessage());
        return Flux.just(new SleeperUser());
    }

}
