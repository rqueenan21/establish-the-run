package com.establish.the.run.nfl.model.sleeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor
@AllArgsConstructor
public class SleeperUser {

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("display_name")
    private String displayName;

}
