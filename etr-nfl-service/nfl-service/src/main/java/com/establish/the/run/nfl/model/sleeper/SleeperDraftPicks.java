package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleeperDraftPicks {

    private String season;
    private Integer round;
    @JsonProperty("roster_id")
    private Integer rosterId;
    @JsonProperty("previous_owner_id")
    private Integer previousOwnerId;
    @JsonProperty("owner_id")
    private Long ownerId;


}
