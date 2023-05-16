package com.establish.the.run.client.service;

import com.establish.the.run.client.exceptions.JobCreationException;
import com.establish.the.run.client.model.job.Job;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service @RequiredArgsConstructor @Slf4j
public class JobManagementServiceImpl implements JobManagementService {

    private final WebClient webClient;

    @Override
    @Retry(name = "dataService")
    public Mono<Job> createJob(Job job) {
        log.debug("Creating job id {}, job type {}", job.getJobId(), job.getJobType());
        return webClient.post().uri("http://ETR-NFL-DATA/job")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(job))
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> {
                    log.error("Error creating job {}, job id {} with status of {}", job.getJobType(), job.getJobId(), clientResponse.statusCode());
                    throw new JobCreationException("Error creating the job id");
                })
                .bodyToMono(Job.class);
    }

    @Override
    @Retry(name = "dataService")
    public Mono<Job> updateJob(Job job) {
        log.debug("Updating job id {}, job type {}, to status {} ", job.getJobId(), job.getJobType(), job.getStatus());
        return webClient.put().uri("http://ETR-NFL-DATA/job")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(job))
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse -> {
                    log.error("Error updating job {}, job id {} with status of {}", job.getJobType(), job.getJobId(), clientResponse.statusCode());
                    throw new JobCreationException("Error updating the job id");
                })
                .bodyToMono(Job.class);
    }
}
