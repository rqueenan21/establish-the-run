package com.establish.the.run.nfl.model.sleeper.dto;

import com.establish.the.run.nfl.model.sleeper.SleeperLeagueScoringSettings;
import com.establish.the.run.nfl.model.sleeper.SleeperLeagueSettings;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SleeperLeagueDto {
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
    private SleeperLeagueSettingsDto settings;
    private SleeperLeagueScoringSettingsDto scoringSettings;
}
