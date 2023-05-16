package com.establish.the.run.nfl.data.model.trade.calculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Document("leagues")
public class League {
    @Id
    private String leagueId;
    private String name;
    private String season;
    private Integer totalRosters;
    private String status;
    private String sport;
    private Long shard;
    private String seasonType;
    private List<String> rosterPositions;
    private String prevLeagueId;
    private String draftId;
    private LeagueSettings settings;
    private LeagueScoringSettings scoringSettings;

}
