package com.establish.the.run.nfl.model.sleeper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleeperLeagueScoringSettingsDto {
    private Float passYd;
    private Float rushYrd;
    private Float receivingYrd;
    private Float rec;
    private Float passTd;
    private Float rushTd;
    private Float recTd;
    private Float passTwoPt;
    private Float recTwoPt;
    private Float rushTwoPt;
    private Float fumble;
    private Float fumbleLost;
    private Float passInt;
    private Float sack;
    private Float fumRecTd;
}
