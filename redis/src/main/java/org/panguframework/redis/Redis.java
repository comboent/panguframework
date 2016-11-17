package org.panguframework.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class Redis implements JedisCommands {
    private static final Logger log = LoggerFactory.getLogger(Redis.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            log.error("getRedisClent error", e);
        }
       return null;
    }

    @Override
    public String set(String key, String value) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.set(key, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String set(String key, String value, String nxxx, String expx, long time) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.set(key, value, nxxx, expx, time);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String set(String key, String value, String nxxx) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.set(key, value, nxxx);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String get(String key) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.get(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Boolean result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.exists(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long persist(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.persist(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String type(String key) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.type(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long expire(String key, int seconds) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.expire(key, seconds);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long pexpire(String key, long milliseconds) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.pexpire(key, milliseconds);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long expireAt(String key, long unixTime) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.expireAt(key, unixTime);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long pexpireAt(String key, long millisecondsTimestamp) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.pexpireAt(key, millisecondsTimestamp);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long ttl(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.ttl(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long pttl(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.pttl(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Boolean setbit(String key, long offset, boolean value) {
        Boolean result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.setbit(key, offset, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Boolean setbit(String key, long offset, String value) {
        Boolean result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.setbit(key, offset, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Boolean getbit(String key, long offset) {
        Boolean result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.getbit(key, offset);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long setrange(String key, long offset, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.setrange(key, offset, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String getrange(String key, long startOffset, long endOffset) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.getrange(key, startOffset, endOffset);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String getSet(String key, String value) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.getSet(key, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long setnx(String key, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.setnx(key, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String setex(String key, int seconds, String value) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.setex(key, seconds, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String psetex(String key, long milliseconds, String value) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.psetex(key, milliseconds, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long decrBy(String key, long integer) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.decrBy(key, integer);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long decr(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.decr(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long incrBy(String key, long integer) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.incrBy(key, integer);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Double incrByFloat(String key, double value) {
        Double result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.incrByFloat(key, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long incr(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.incr(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long append(String key, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.append(key, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String substr(String key, int start, int end) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.substr(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long hset(String key, String field, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hset(key, field, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String hget(String key, String field) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hget(key, field);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hsetnx(key, field, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hmset(key, hash);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hmget(key, fields);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long hincrBy(String key, String field, long value) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hincrBy(key, field, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Double hincrByFloat(String key, String field, double value) {
        Double result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hincrByFloat(key, field, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Boolean hexists(String key, String field) {
        Boolean result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hexists(key, field);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long hdel(String key, String... field) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hdel(key, field);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long hlen(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hlen(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> hkeys(String key) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hkeys(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> hvals(String key) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hvals(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Map<String, String> hgetAll(String key) {
        Map<String, String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hgetAll(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long rpush(String key, String... string) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.rpush(key, string);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long lpush(String key, String... string) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lpush(key, string);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long llen(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.llen(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lrange(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String ltrim(String key, long start, long end) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.ltrim(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String lindex(String key, long index) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lindex(key, index);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String lset(String key, long index, String value) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lset(key, index, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long lrem(String key, long count, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lrem(key, count, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String lpop(String key) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lpop(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String rpop(String key) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.rpop(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long sadd(String key, String... member) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.sadd(key, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> smembers(String key) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.smembers(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long srem(String key, String... member) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.srem(key, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String spop(String key) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.spop(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> spop(String key, long count) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.spop(key, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long scard(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.scard(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Boolean sismember(String key, String member) {
        Boolean result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.sismember(key, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String srandmember(String key) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.srandmember(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> srandmember(String key, int count) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.srandmember(key, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long strlen(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.strlen(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zadd(String key, double score, String member) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zadd(key, score, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zadd(String key, double score, String member, ZAddParams params) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zadd(key, score, member, params);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zadd(String key, Map<String, Double> scoreMembers) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zadd(key, scoreMembers);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zadd(key, scoreMembers, params);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrange(String key, long start, long end) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrange(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zrem(String key, String... member) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrem(key, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Double zincrby(String key, double score, String member) {
        Double result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zincrby(key, score, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Double zincrby(String key, double score, String member, ZIncrByParams params) {
        Double result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zincrby(key, score, member, params);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zrank(String key, String member) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrank(key, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zrevrank(String key, String member) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrank(key, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrevrange(String key, long start, long end) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrange(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeWithScores(String key, long start, long end) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeWithScores(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeWithScores(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zcard(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zcard(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Double zscore(String key, String member) {
        Double result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zscore(key, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> sort(String key) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.sort(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> sort(String key, SortingParams sortingParameters) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.sort(key, sortingParameters);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zcount(String key, double min, double max) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zcount(key, min, max);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zcount(String key, String min, String max) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zcount(key, min, max);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByScore(key, min, max);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, String min, String max) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByScore(key, min, max);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByScore(key, max, min);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByScore(key, min, max, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, String max, String min) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByScore(key, max, min);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByScore(key, min, max, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByScore(key, max, min, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByScoreWithScores(key, min, max);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByScoreWithScores(key, max, min);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByScoreWithScores(key, min, max, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByScore(key, max, min, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByScoreWithScores(key, min, max);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByScoreWithScores(key, max, min);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByScoreWithScores(key, min, max, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count) {
        Set<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByScoreWithScores(key, max, min, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zremrangeByRank(String key, long start, long end) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zremrangeByRank(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zremrangeByScore(String key, double start, double end) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zremrangeByScore(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zremrangeByScore(String key, String start, String end) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zremrangeByScore(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zlexcount(String key, String min, String max) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zlexcount(key, min, max);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrangeByLex(String key, String min, String max) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByLex(key, min, max);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrangeByLex(String key, String min, String max, int offset, int count) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrangeByLex(key, min, max, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByLex(String key, String max, String min) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByLex(key, max, min);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Set<String> zrevrangeByLex(String key, String max, String min, int offset, int count) {
        Set<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zrevrangeByLex(key, max, min, offset, count);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long zremrangeByLex(String key, String min, String max) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zremrangeByLex(key, min, max);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.linsert(key, where, pivot, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long lpushx(String key, String... string) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lpushx(key, string);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long rpushx(String key, String... string) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.rpushx(key, string);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> blpop(String arg) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.blpop(arg);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> blpop(int timeout, String key) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.blpop(timeout, key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> brpop(String arg) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.brpop(arg);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> brpop(int timeout, String key) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.brpop(timeout, key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long del(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.del(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public String echo(String string) {
        String result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.echo(string);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long move(String key, int dbIndex) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.move(key, dbIndex);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long bitcount(String key) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.bitcount(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long bitcount(String key, long start, long end) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.bitcount(key, start, end);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long bitpos(String key, boolean value) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.bitpos(key, value);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long bitpos(String key, boolean value, BitPosParams params) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.bitpos(key, value, params);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, int cursor) {
        ScanResult<Map.Entry<String, String>> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hscan(key, cursor);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public ScanResult<String> sscan(String key, int cursor) {
        ScanResult<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.sscan(key, cursor);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    @Deprecated
    public ScanResult<Tuple> zscan(String key, int cursor) {
        ScanResult<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zscan(key, cursor);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor) {
        ScanResult<Map.Entry<String, String>> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hscan(key, cursor);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params) {
        ScanResult<Map.Entry<String, String>> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hscan(key, cursor, params);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor) {
        ScanResult<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.sscan(key, cursor);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
        ScanResult<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.sscan(key, cursor, params);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor) {
        ScanResult<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zscan(key, cursor);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
        ScanResult<Tuple> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.zscan(key, cursor, params);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long pfadd(String key, String... elements) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.pfadd(key, elements);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public long pfcount(String key) {
        long result = 0;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.pfcount(key);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long geoadd(String key, double longitude, double latitude, String member) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.geoadd(key, longitude, latitude, member);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.geoadd(key, memberCoordinateMap);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Double geodist(String key, String member1, String member2) {
        Double result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.geodist(key, member1, member2);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Double geodist(String key, String member1, String member2, GeoUnit unit) {
        Double result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.geodist(key, member1, member2, unit);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<String> geohash(String key, String... members) {
        List<String> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.geohash(key, members);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<GeoCoordinate> geopos(String key, String... members) {
        List<GeoCoordinate> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.geopos(key, members);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit) {
        List<GeoRadiusResponse> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.georadius(key, longitude, latitude, radius, unit);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadius(String key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
        List<GeoRadiusResponse> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.georadius(key, longitude, latitude, radius, unit, param);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit) {
        List<GeoRadiusResponse> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.georadiusByMember(key, member, radius, unit);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<GeoRadiusResponse> georadiusByMember(String key, String member, double radius, GeoUnit unit, GeoRadiusParam param) {
        List<GeoRadiusResponse> result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.georadiusByMember(key, member, radius, unit, param);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }
}
