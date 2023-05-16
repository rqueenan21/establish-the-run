package com.establish.the.run.client.model.job;


import com.establish.the.run.client.model.common.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    private String jobId;
    @NotNull
    private JobType jobType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;

}
