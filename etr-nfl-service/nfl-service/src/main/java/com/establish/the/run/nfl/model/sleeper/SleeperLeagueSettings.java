package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleeperLeagueSettings {

    @JsonProperty("daily_waivers_last_ran")
    private Long dailyWaiversLastRan;
    @JsonProperty("reserve_allow_cov")
    private Integer reserveAllowCov;
    @JsonProperty("reserve_slots")
    private Integer reserveSlots;
    private Integer leg;
    @JsonProperty("offseason_adds")
    private Long offseasonAdds;
    @JsonProperty("bench_lock")
    private Long benchLock;
    @JsonProperty("trade_review_days")
    private Long tradeReviewDays;
    @JsonProperty("waiver_type")
    private Integer waiverType;
    @JsonProperty("max_keepers")
    private Integer maxKeepers;
    private Integer type;
    @JsonProperty("pick_trading")
    private Integer pickTrading;
    @JsonProperty("disable_trades")
    private Integer disableTrades;
    @JsonProperty("position_limit_def")
    private Integer posLimitDef;
    @JsonProperty("daily_waivers")
    private Integer dailyWaivers;
    @JsonProperty("num_teams")
    private Integer numTeams;
    private Integer squads;
    @JsonProperty("position_limit_qb")
    private Integer posLimitQb;
    @JsonProperty("playoff_teams")
    private Integer playoffTeams;
    @JsonProperty("playoff_seed_type")
    private Integer playoffSeedType;
    @JsonProperty("start_week")
    private Integer startWeek;
    @JsonProperty("reserve_allow_na")
    private Integer reserveAllowNa;
    @JsonProperty("draft_rounds")
    private Integer draftRounds;
    @JsonProperty("taxi_deadline")
    private Integer taxiDeadline;
    @JsonProperty("position_limit_te")
    private Integer positionLimitTe;
    @JsonProperty("capacity_override")
    private Integer capacityOverride;
    private Integer divisions;
    @JsonProperty("disable_adds")
    private Integer disableAdds;
    @JsonProperty("waiver_budget")
    private Long waiverBudget;
    @JsonProperty("last_report")
    private Integer lastReport;
    @JsonProperty("best_ball")
    private Integer bestBall;


}
