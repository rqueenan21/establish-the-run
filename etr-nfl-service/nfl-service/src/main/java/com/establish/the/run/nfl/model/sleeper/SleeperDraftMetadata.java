package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleeperDraftMetadata {

    @JsonProperty("scoring_type")
    private String scoringType;
    private String name;
    private String description;

}
