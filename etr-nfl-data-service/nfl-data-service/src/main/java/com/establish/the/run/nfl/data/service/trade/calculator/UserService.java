package com.establish.the.run.nfl.data.service.trade.calculator;

import com.establish.the.run.nfl.data.model.trade.calculator.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> findAll();

    Mono<User> saveUser(User user);

    Mono<User> getUser(String userId);

    Mono<User> updateUser(User user, String userId);

    Mono<Void> deleteUser(String userId);

}
