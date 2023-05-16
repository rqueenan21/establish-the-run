package com.establish.the.run.client.controller.trade.calculator;

import com.establish.the.run.client.model.common.Status;
import com.establish.the.run.client.model.job.Job;
import com.establish.the.run.client.model.sleeper.SleeperLeague;
import com.establish.the.run.client.service.EtrNflService;
import com.establish.the.run.client.service.JobManagementService;
import com.establish.the.run.client.service.TradeCalculatorService;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController @RequiredArgsConstructor
@RequestMapping("/trade/calculator")
public class TradeCalculatorController {

    private final TradeCalculatorService tradeCalcService;
    private final EtrNflService nflService;

    @PostMapping("job")
    public Flux<SleeperLeague> startTradeCalcBatch(@RequestBody Job job){
        return tradeCalcService.startTradeCalcBatch(job);
    }

    @Observed(name = "demo")
    @GetMapping()
    public Flux<SleeperLeague> startTradeCalcBatch(){
        return nflService.getLeaguesByUser("866923252235272192");
    }

}
