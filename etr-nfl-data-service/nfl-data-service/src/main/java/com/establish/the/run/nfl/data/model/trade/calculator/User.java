package com.establish.the.run.nfl.data.model.trade.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "users")
public class User {
    @Id
    private String userId;
    private String displayName;
}
