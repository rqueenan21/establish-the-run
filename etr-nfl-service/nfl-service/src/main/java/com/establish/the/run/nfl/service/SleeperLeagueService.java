package com.establish.the.run.nfl.service;

import com.establish.the.run.nfl.model.sleeper.SleeperLeague;
import com.establish.the.run.nfl.model.sleeper.dto.SleeperLeagueDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SleeperLeagueService {

    Flux<SleeperLeagueDto> getSleeperLeaguesByUser(String userId);

}
