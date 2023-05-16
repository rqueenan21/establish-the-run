package com.establish.the.run.nfl.data.service.job;

import com.establish.the.run.nfl.data.model.common.Status;
import com.establish.the.run.nfl.data.model.job.Job;
import com.establish.the.run.nfl.data.repository.job.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service @RequiredArgsConstructor @Slf4j
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepo;
    @Override
    public Mono<Job> createJob(Job job) {
        job.setStartTime(LocalDateTime.now());
        job.setStatus(Status.IN_PROGRESS);
        Mono<Job> createdJob = jobRepo.insert(job);
        log.info("Created job {} with status of {}", job.getJobId(), job.getStatus());
        return createdJob;
    }

    @Override
    public Mono<Job> updateJob(Job job) {
        log.info("Updated job {} with status of {}", job.getJobId(), job.getStatus());
        return jobRepo.save(job);
    }

    @Override
    public Mono<Job> getJobById(String jobId) {
        return jobRepo.findById(jobId);
    }

    @Override
    public Mono<Void> deleteJob(String jobId) {
        return jobRepo.deleteById(jobId);
    }

}
