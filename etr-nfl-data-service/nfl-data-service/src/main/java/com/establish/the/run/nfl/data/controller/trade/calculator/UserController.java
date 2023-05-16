package com.establish.the.run.nfl.data.controller.trade.calculator;

import com.establish.the.run.nfl.data.model.trade.calculator.User;
import com.establish.the.run.nfl.data.service.trade.calculator.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("sleeper/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<User> saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("{id}")
    public Mono<User> getUser(@PathVariable("id") String userId){
        return userService.getUser(userId);
    }

    @PutMapping("{id}")
    public Mono<User> updateUser(@RequestBody User user, @PathVariable("id") String userId){
        return userService.updateUser(user, userId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUser(@PathVariable("id") String userId){
        return userService.deleteUser(userId);
    }

}
