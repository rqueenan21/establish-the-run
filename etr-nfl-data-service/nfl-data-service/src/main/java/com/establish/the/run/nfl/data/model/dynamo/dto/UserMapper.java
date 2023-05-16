package com.establish.the.run.nfl.data.model.dynamo.dto;

import com.establish.the.run.nfl.data.model.trade.calculator.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(UserDto user);
}
