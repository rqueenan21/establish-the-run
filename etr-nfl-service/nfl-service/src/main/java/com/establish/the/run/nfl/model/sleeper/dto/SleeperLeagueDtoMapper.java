package com.establish.the.run.nfl.model.sleeper.dto;

import com.establish.the.run.nfl.model.sleeper.SleeperLeague;
import com.establish.the.run.nfl.model.sleeper.SleeperLeagueScoringSettings;
import com.establish.the.run.nfl.model.sleeper.SleeperLeagueSettings;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SleeperLeagueDtoMapper {
    SleeperLeagueDto sleeperLeagueMapper(SleeperLeague league);
    SleeperLeagueSettingsDto sleeperLeagueSettingsDtoMapper(SleeperLeagueSettings leagueSettings);
    SleeperLeagueScoringSettingsDto scoringSettingsMapper(SleeperLeagueScoringSettings leagueScoringSettings);
}
