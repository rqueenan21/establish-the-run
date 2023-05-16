package com.establish.the.run.client.service;

import com.establish.the.run.client.model.common.Status;
import com.establish.the.run.client.model.job.Job;
import com.establish.the.run.client.model.sleeper.SleeperLeague;
import com.establish.the.run.client.model.sleeper.SleeperUser;
import io.github.resilience4j.reactor.retry.RetryOperator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service @RequiredArgsConstructor @Slf4j
public class TradeCalculatorServiceImpl implements TradeCalculatorService {

    private final JobManagementService jobManagementService;
    private final EtrDataService etrDataService;
    private final EtrNflService etrNflService;

    @Override
    public Flux<SleeperLeague> startTradeCalcBatch(Job job) {
        job.setJobId(UUID.randomUUID().toString());
        log.info("Starting job for {}", job.getJobType());
        // Call NFL Data Service to create job in Mongo for tracking purposes
        Mono<Job> runningJob = jobManagementService.createJob(job);
        // Call NFL Data Service to get all previously stored Sleeper Users
        Flux<SleeperLeague> addedLeagues = etrDataService.getAllSleeperUsers().map(SleeperUser::getUserId)
                //.transformDeferred(RetryOperator.of(retryR)).map(SleeperUser::getUserId)
                // Call ETR NFL Service to parallelize calls to Sleeper APIs to get all leagues that currently stored users are in
                .flatMap(etrNflService::getLeaguesByUser)
                // Add leagues to DB
                .flatMap(etrDataService::addSleeperLeague)
                .doOnError(ex -> updateJobStatus(job, Status.FAILURE))
                .doOnCancel(() -> updateJobStatus(job, Status.CANCELLED));
        job.setStatus(Status.SUCCESS);
        job.setEndTime(LocalDateTime.now());
        jobManagementService.updateJob(job);
        return addedLeagues;
    }

    private Mono<Job> updateJobStatus(Job job, Status status){
        if(!Status.FAILURE.equals(job.getStatus())){
            job.setStatus(status);
        }
        job.setEndTime(LocalDateTime.now());
        return jobManagementService.updateJob(job);
    }


}
