package com.establish.the.run.client.service;

import com.establish.the.run.client.model.job.Job;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import reactor.core.publisher.Mono;

public interface JobManagementService {

    Mono<Job> createJob(Job job);

    Mono<Job> updateJob(Job job);

}
