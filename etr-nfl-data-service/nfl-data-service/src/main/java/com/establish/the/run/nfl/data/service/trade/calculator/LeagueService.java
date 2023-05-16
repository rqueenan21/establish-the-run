package com.establish.the.run.nfl.data.service.trade.calculator;

import com.establish.the.run.nfl.data.model.trade.calculator.League;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LeagueService {

    Flux<League> findAll();

    Mono<League> saveLeague(League user);

    Mono<League> getLeague(String userId);

    Mono<League> updateLeague(League user, String userId);

    Mono<Void> deleteLeague(String userId);
}
