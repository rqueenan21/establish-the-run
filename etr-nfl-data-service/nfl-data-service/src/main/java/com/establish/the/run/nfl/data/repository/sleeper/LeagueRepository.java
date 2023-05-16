package com.establish.the.run.nfl.data.repository.sleeper;

import com.establish.the.run.nfl.data.model.trade.calculator.League;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LeagueRepository extends ReactiveMongoRepository<League, String> {
}
