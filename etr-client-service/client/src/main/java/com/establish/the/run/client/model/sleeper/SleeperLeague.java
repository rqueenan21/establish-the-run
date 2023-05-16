package com.establish.the.run.client.model.sleeper;

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
    private Integer totalRosters;
    private String status;
    private String sport;
    private Long shard;
    private String seasonType;
    private String leagueId;
    private List<String> rosterPositions;
    private String prevLeagueId;
    private String draftId;
    private SleeperLeagueSettings settings;
    private SleeperLeagueScoringSettings scoringSettings;

}
