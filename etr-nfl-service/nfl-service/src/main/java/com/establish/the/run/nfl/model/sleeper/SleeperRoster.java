package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SleeperRoster {

    private List<String> taxi;
    private List<String> starters;
    private SleeperRosterSettings settings;
    @JsonProperty("roster_id")
    private Long rosterId;
    private List<String> reserve;
    private List<String> players;
    @JsonProperty("owner_id")
    private String ownerId;
    @JsonProperty("player_id")
    private String leagueId;
}
