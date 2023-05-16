package com.establish.the.run.nfl.model.sleeper.dto;

import com.establish.the.run.nfl.model.sleeper.SleeperLeague;
import com.establish.the.run.nfl.model.sleeper.SleeperLeagueScoringSettings;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScoringSettingsDtoMapper {
    SleeperLeagueScoringSettingsDto scoringSettingsMapper(SleeperLeagueScoringSettings leagueScoringSettings);
}
