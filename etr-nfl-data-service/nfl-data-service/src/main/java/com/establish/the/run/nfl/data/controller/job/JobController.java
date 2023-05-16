package com.establish.the.run.nfl.data.controller.job;

import com.establish.the.run.nfl.data.model.job.Job;
import com.establish.the.run.nfl.data.service.job.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController @RequiredArgsConstructor
@RequestMapping("job")
public class JobController {

    private final JobService jobService;

    @PostMapping
    public Mono<Job> createJob(Job job) {
        return jobService.createJob(job);
    }

    @PutMapping
    public Mono<Job> updateJob(Job job) {
        return jobService.updateJob(job);
    }

}
