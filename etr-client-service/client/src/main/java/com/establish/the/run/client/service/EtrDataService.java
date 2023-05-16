package com.establish.the.run.client.service;

import com.establish.the.run.client.model.sleeper.SleeperLeague;
import com.establish.the.run.client.model.sleeper.SleeperUser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EtrDataService {

    Flux<SleeperUser> getAllSleeperUsers();

    Mono<SleeperLeague> addSleeperLeague(SleeperLeague league);

}
