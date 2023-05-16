package com.establish.the.run.nfl.model.sleeper.dto;

import com.establish.the.run.nfl.model.sleeper.SleeperLeague;
import com.establish.the.run.nfl.model.sleeper.SleeperLeagueSettings;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SleeperLeagueSettingsDtoMapper {
    SleeperLeagueSettingsDto sleeperLeagueSettingsDtoMapper(SleeperLeagueSettings leagueSettings);
}
