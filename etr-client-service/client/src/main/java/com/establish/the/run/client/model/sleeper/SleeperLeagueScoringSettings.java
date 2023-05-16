package com.establish.the.run.client.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleeperLeagueScoringSettings {
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
    private Float Sack;
    private Float fumRecTd;
}
