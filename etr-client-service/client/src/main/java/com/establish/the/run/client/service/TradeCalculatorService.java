package com.establish.the.run.client.service;

import com.establish.the.run.client.model.job.Job;
import com.establish.the.run.client.model.sleeper.SleeperLeague;
import reactor.core.publisher.Flux;

public interface TradeCalculatorService {

    Flux<SleeperLeague> startTradeCalcBatch(Job job);

}
