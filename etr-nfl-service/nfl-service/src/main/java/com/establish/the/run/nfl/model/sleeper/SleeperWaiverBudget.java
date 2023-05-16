package com.establish.the.run.nfl.model.sleeper;

import lombok.Data;

@Data
public class SleeperWaiverBudget {

    private Integer sender;
    private Integer receiver;
    private Long amount;
}
