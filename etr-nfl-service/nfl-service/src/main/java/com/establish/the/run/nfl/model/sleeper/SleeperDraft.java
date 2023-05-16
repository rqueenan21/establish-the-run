package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;

@Data
public class SleeperDraft {
    @JsonProperty("draft_id")
    private String draftId;
    private String type;
    private String status;
    private String sport;
    @JsonProperty("season_type")
    private String seasonType;
    private String season;
    private SleeperDraftMetadata metadata;
    @JsonProperty("league_id")
    private String leagueId;
    @JsonProperty("draft_order")
    private HashMap<String, Integer> draftOrder;

    private SleeperDraftSettings settings;

    @JsonProperty("slot_to_roster_id")
    private HashMap<String, Integer> slotToRosterId;
}
