package com.establish.the.run.nfl.data.service.job;

import com.establish.the.run.nfl.data.model.job.Job;
import reactor.core.publisher.Mono;

public interface JobService {

    Mono<Job> createJob(Job job);

    Mono<Job> updateJob(Job job);

    Mono<Job> getJobById(String jobId);

    Mono<Void> deleteJob(String jobId);

}
