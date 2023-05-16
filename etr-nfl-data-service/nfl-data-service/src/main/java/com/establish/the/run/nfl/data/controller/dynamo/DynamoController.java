package com.establish.the.run.nfl.data.controller.dynamo;

import com.establish.the.run.nfl.data.model.dynamo.dto.UserDto;
import com.establish.the.run.nfl.data.model.dynamo.dto.UserMapper;
import com.establish.the.run.nfl.data.model.trade.calculator.User;
import com.establish.the.run.nfl.data.repository.dynamo.DynamoUserRepository;
import com.establish.the.run.nfl.data.service.trade.calculator.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController @RequiredArgsConstructor
public class DynamoController {

    private final DynamoUserRepository dynamoUserRepository;
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("test")
    public Flux<User> dataMigration(){
        return dynamoUserRepository.getAllUsers().map(userMapper::map).flatMap(userService::saveUser);
    }

    @GetMapping("test/{id}")
    public Mono<User> getUser(@PathVariable("id") String userId){
        return dynamoUserRepository.getUser(userId).map(userMapper::map).flatMap(userService::saveUser);
    }


}
