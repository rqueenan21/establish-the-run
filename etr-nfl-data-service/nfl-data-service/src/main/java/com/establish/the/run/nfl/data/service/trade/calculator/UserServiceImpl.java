package com.establish.the.run.nfl.data.service.trade.calculator;

import com.establish.the.run.nfl.data.model.trade.calculator.User;
import com.establish.the.run.nfl.data.repository.sleeper.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service @Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Override
    public Flux<User> findAll(){
        log.info("Retrieving all users");
        //throw new RuntimeException("Error somewhere");
        return userRepo.findAll();
    }

    @Override
    public Mono<User> saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Mono<User> getUser(String userId) {
        return userRepo.findById(userId);
    }

    @Override
    public Mono<User> updateUser(User user, String userId) {
        Mono<User> userToUpdate =  userRepo.findById(userId);

        return userToUpdate.flatMap(existingUser ->  {
            existingUser.setDisplayName(user.getDisplayName());
            return userRepo.save(existingUser);
        });
    }

    @Override
    public Mono<Void> deleteUser(String userId) {
        return userRepo.deleteById(userId);
    }

}
