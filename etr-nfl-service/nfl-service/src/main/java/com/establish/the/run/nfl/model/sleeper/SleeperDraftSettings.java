package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleeperDraftSettings {

    private Integer teams;
    @JsonProperty("slots_wr")
    private Integer wrSlots;
    @JsonProperty("slots_rb")
    private Integer rbSlots;
    @JsonProperty("slots_te")
    private Integer teSlots;
    @JsonProperty("slots_qb")
    private Integer qbSlots;
    @JsonProperty("slots_flex")
    private Integer flexSlots;
    @JsonProperty("slots_bn")
    private Integer benchSlots;
    private Integer rounds;
}
