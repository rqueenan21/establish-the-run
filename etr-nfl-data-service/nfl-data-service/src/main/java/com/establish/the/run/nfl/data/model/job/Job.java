package com.establish.the.run.nfl.data.model.job;

import com.establish.the.run.nfl.data.model.common.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "jobs")
public class Job {
    @Id
    private String jobId;
    private JobType jobType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;

}
