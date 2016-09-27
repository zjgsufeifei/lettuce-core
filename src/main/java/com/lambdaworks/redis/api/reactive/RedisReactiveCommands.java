package com.lambdaworks.redis.api.reactive;

import java.util.concurrent.TimeUnit;

import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.cluster.api.reactive.RedisClusterReactiveCommands;

import reactor.core.publisher.Mono;

/**
 * A complete reactive and thread-safe Redis API with 400+ Methods.
 * 
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mark Paluch
 * @since 5.0
 */
public interface RedisReactiveCommands<K, V> extends RedisHashReactiveCommands<K, V>, RedisKeyReactiveCommands<K, V>,
        RedisStringReactiveCommands<K, V>, RedisListReactiveCommands<K, V>, RedisSetReactiveCommands<K, V>,
        RedisSortedSetReactiveCommands<K, V>, RedisScriptingReactiveCommands<K, V>, RedisServerReactiveCommands<K, V>,
        RedisHLLReactiveCommands<K, V>, BaseRedisReactiveCommands<K, V>, RedisClusterReactiveCommands<K, V>,
        RedisTransactionalReactiveCommands<K, V>, RedisGeoReactiveCommands<K, V> {

    /**
     * Set the default timeout for operations.
     * 
     * @param timeout the timeout value
     * @param unit the unit of the timeout value
     */
    void setTimeout(long timeout, TimeUnit unit);

    /**
     * Authenticate to the server.
     * 
     * @param password the password
     * @return String simple-string-reply
     */
    Mono<String> auth(String password);

    /**
     * Change the selected database for the current connection.
     * 
     * @param db the database number
     * @return String simple-string-reply
     */
    Mono<String> select(int db);

    /**
     * @return the underlying connection.
     */
    StatefulRedisConnection<K, V> getStatefulConnection();

}