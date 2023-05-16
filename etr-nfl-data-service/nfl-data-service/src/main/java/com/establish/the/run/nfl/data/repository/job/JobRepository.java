package com.establish.the.run.nfl.data.repository.job;

import com.establish.the.run.nfl.data.model.job.Job;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface JobRepository extends ReactiveMongoRepository<Job, String> {
}
