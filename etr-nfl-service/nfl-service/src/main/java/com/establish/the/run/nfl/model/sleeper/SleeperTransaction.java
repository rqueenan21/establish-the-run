package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

@Data
public class SleeperTransaction {

    private String type;
    @JsonProperty("transaction_id")
    private String transactionId;
    private String status;
    private List<Integer> rosterIds;
    private Integer leg;
    private Map<String, Integer> drops;
    private Map<String, Integer> adds;
    private Long creator;
    @JsonProperty("league_id")
    private String leagueId;
    @JsonProperty("consenter_ids")
    private List<Integer> consenterIds;

    private Long created;
    @JsonProperty("status_updated")
    private Long statusUpdated;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @JsonProperty("draft_picks")
    private List<SleeperDraftPicks> draftPicks;
    @JsonProperty("waiver_budget")
    private List<SleeperWaiverBudget> waiverBudget;

    private Integer week;

    public void setWeek(){
        this.week = this.getLeg();
    }

    public void setCreatedTime(){
        this.createdTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(this.created), ZoneId.of("America/New_York"));
    }

    public void setUpdatedTime(){
        this.updatedTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(this.statusUpdated), ZoneId.of("America/New_York"));
    }

}
