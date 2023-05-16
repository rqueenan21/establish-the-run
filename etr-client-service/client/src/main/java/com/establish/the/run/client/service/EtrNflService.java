package com.establish.the.run.client.service;

import com.establish.the.run.client.model.sleeper.SleeperLeague;
import reactor.core.publisher.Flux;

public interface EtrNflService {

    Flux<SleeperLeague> getLeaguesByUser(String userId);

}
