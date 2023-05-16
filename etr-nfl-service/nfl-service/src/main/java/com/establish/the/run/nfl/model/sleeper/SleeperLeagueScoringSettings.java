package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleeperLeagueScoringSettings {

    @JsonProperty("pass_yd")
    private Float passYd;
    @JsonProperty("rush_yd")
    private Float rushYrd;
    @JsonProperty("rec_yd")
    private Float receivingYrd;
    private Float rec;
    @JsonProperty("pass_td")
    private Float passTd;
    @JsonProperty("rush_td")
    private Float rushTd;
    @JsonProperty("rec_td")
    private Float recTd;
    @JsonProperty("pass_2pt")
    private Float passTwoPt;
    @JsonProperty("rec_2pt")
    private Float recTwoPt;
    @JsonProperty("rush_2pt")
    private Float rushTwoPt;
    @JsonProperty("fum")
    private Float fumble;
    @JsonProperty("fum_lost")
    private Float fumbleLost;
    @JsonProperty("pass_int")
    private Float passInt;
    @JsonProperty("sack")
    private Float sack;
    @JsonProperty("fum_rec_td")
    private Float fumRecTd;
}
