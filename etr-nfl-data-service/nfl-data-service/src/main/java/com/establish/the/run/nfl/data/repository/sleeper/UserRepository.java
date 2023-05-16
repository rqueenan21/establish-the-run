package com.establish.the.run.nfl.data.repository.sleeper;

import com.establish.the.run.nfl.data.model.trade.calculator.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
