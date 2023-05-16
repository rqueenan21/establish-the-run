package com.establish.the.run.nfl.model.sleeper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleeperLeagueSettingsDto {
    private Long dailyWaiversLastRan;
    private Integer reserveAllowCov;
    private Integer reserveSlots;
    private Integer leg;
    private Long offSeasonAdds;
    private Long benchLock;
    private Long tradeReviewDays;
    private Integer waiverType;
    private Integer maxKeepers;
    private Integer type;
    private Integer pickTrading;
    private Integer disableTrades;
    private Integer posLimitDef;
    private Integer dailyWaivers;
    private Integer numTeams;
    private Integer squads;
    private Integer posLimitQb;
    private Integer playoffTeams;
    private Integer playoffSeedType;
    private Integer startWeek;
    private Integer reserveAllowNa;
    private Integer draftRounds;
    private Integer taxiDeadline;
    private Integer positionLimitTe;
    private Integer capacityOverride;
    private Integer divisions;
    private Integer disableAdds;
    private Long waiverBudget;
    private Integer lastReport;
    private Integer bestBall;

}
