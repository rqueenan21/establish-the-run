package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class SleeperLeague {

    private String name;
    private String season;
    @JsonProperty("total_rosters")
    private Integer totalRosters;
    private String status;
    private String sport;
    private Long shard;

    @JsonProperty("season_type")
    private String seasonType;

    @JsonProperty("league_id")
    private String leagueId;

    @JsonProperty("roster_positions")
    private List<String> rosterPositions;
    @JsonProperty("previous_league_id")
    private String prevLeagueId;

    @JsonProperty("draft_id")
    private String draftId;

    private SleeperLeagueSettings settings;
    @JsonProperty("scoring_settings")
    private SleeperLeagueScoringSettings scoringSettings;

}
