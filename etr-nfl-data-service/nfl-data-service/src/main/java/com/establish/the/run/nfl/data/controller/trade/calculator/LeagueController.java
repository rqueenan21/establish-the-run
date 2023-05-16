package com.establish.the.run.nfl.data.controller.trade.calculator;

import com.establish.the.run.nfl.data.model.trade.calculator.League;
import com.establish.the.run.nfl.data.service.trade.calculator.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController @RequiredArgsConstructor
@RequestMapping("sleeper/leagues")
public class LeagueController {
    private final LeagueService leagueService;

    //@GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<League> findAll(){
        return leagueService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<League> saveLeague(@RequestBody League league){
        return leagueService.saveLeague(league);
    }

    @GetMapping("{id}")
    public Mono<League> getLeague(@PathVariable("id") String leagueId){
        return leagueService.getLeague(leagueId);
    }

    @PutMapping("{id}")
    public Mono<League> updateLeague(@RequestBody League league, @PathVariable("id") String leagueId){
        return leagueService.updateLeague(league, leagueId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteLeague(@PathVariable("id") String leagueId){
        return leagueService.deleteLeague(leagueId);
    }

}
