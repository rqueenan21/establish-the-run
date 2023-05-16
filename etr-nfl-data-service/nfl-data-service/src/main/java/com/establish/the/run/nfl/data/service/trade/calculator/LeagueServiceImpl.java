package com.establish.the.run.nfl.data.service.trade.calculator;

import com.establish.the.run.nfl.data.model.trade.calculator.League;
import com.establish.the.run.nfl.data.repository.sleeper.LeagueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service @RequiredArgsConstructor @Slf4j
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepo;

    @Override
    public Flux<League> findAll() {
        log.info("Getting all users");
        return leagueRepo.findAll();
    }

    @Override
    public Mono<League> saveLeague(League league) {
        return leagueRepo.save(league);
    }

    @Override
    public Mono<League> getLeague(String leagueId) {
        return leagueRepo.findById(leagueId);
    }

    @Override
    public Mono<League> updateLeague(League league, String leagueId) {
        return leagueRepo.save(league);
    }

    @Override
    public Mono<Void> deleteLeague(String leagueId) {
        return leagueRepo.deleteById(leagueId);
    }
}
