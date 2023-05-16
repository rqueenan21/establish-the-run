package com.establish.the.run.nfl.data.repository.dynamo;

import com.establish.the.run.nfl.data.model.dynamo.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Objects;

@Repository
@Slf4j
public class DynamoUserRepository {

    private final DynamoDbAsyncTable<UserDto> userTable;

    public DynamoUserRepository(DynamoDbEnhancedAsyncClient enhancedDbAsyncClient) {
        this.userTable = enhancedDbAsyncClient.table("User", TableSchema.fromBean(UserDto.class));
    }

    public Flux<UserDto> getAllUsers() {
        return Flux.from(userTable.scan().flatMapIterable(Page::items));
    }

    public Mono<UserDto> getUser(String userId) {
        AttributeValue attVal = AttributeValue.builder()
                .s(userId)
                .build();

        return Mono.fromFuture(userTable.getItem(getKeyBuild(attVal)));
                //.doOnSuccess(Objects::requireNonNull)
                //.onErrorReturn(new UserDto());
    }

    private Key getKeyBuild(AttributeValue attVal) {
        return Key.builder().partitionValue(attVal).build();
    }

}
