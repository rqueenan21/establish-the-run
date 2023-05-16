package com.establish.the.run.nfl.controller.sleeper;

import com.establish.the.run.nfl.model.sleeper.SleeperLeague;
import com.establish.the.run.nfl.model.sleeper.dto.SleeperLeagueDto;
import com.establish.the.run.nfl.service.SleeperLeagueService;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController @RequiredArgsConstructor
@RequestMapping("sleeper/leagues")
public class SleeperLeagueController {

    private final SleeperLeagueService sleeperLeagueService;

    @Observed(name = "league")
    @GetMapping("{id}")
    public Flux<SleeperLeagueDto> getLeague(@PathVariable("id") String userId){
        return sleeperLeagueService.getSleeperLeaguesByUser(userId);
    }


}
