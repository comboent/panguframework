package org.panguframework.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.*;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class BinaryRedis implements BinaryJedisCommands {

    private static final Logger log = LoggerFactory.getLogger(Redis.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedis getRedisClient() {
        try {
            return shardedJedisPool.getResource();
        } catch (Exception e) {
            log.error("getRedisClent error", e);
        }
        return null;
    }

    @Override
    public String set(byte[] key, byte[] value) {
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
    public String set(byte[] key, byte[] value, byte[] nxxx) {
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
    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time) {
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
    public byte[] get(byte[] key) {
        byte[] result = null;
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
    public Boolean exists(byte[] key) {
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
    public Long persist(byte[] key) {
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
    public String type(byte[] key) {
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
    public Long expire(byte[] key, int seconds) {
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
    public Long pexpire(byte[] key, long milliseconds) {
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
    public Long expireAt(byte[] key, long unixTime) {
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
    public Long pexpireAt(byte[] key, long millisecondsTimestamp) {
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
    public Long ttl(byte[] key) {
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
    public Boolean setbit(byte[] key, long offset, boolean value) {
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
    public Boolean setbit(byte[] key, long offset, byte[] value) {
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
    public Boolean getbit(byte[] key, long offset) {
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
    public Long setrange(byte[] key, long offset, byte[] value) {
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
    public byte[] getrange(byte[] key, long startOffset, long endOffset) {
        byte[] result = null;
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
    public byte[] getSet(byte[] key, byte[] value) {
        byte[] result = null;
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
    public Long setnx(byte[] key, byte[] value) {
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
    public String setex(byte[] key, int seconds, byte[] value) {
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
    public Long decrBy(byte[] key, long integer) {
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
    public Long decr(byte[] key) {
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
    public Long incrBy(byte[] key, long integer) {
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
    public Double incrByFloat(byte[] key, double value) {
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
    public Long incr(byte[] key) {
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
    public Long append(byte[] key, byte[] value) {
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
    public byte[] substr(byte[] key, int start, int end) {
        byte[] result = null;
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
    public Long hset(byte[] key, byte[] field, byte[] value) {
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
    public byte[] hget(byte[] key, byte[] field) {
        byte[] result = null;
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
    public Long hsetnx(byte[] key, byte[] field, byte[] value) {
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
    public String hmset(byte[] key, Map<byte[], byte[]> hash) {
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
    public List<byte[]> hmget(byte[] key, byte[]... fields) {
        List<byte[]> result = null;
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
    public Long hincrBy(byte[] key, byte[] field, long value) {
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
    public Double hincrByFloat(byte[] key, byte[] field, double value) {
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
    public Boolean hexists(byte[] key, byte[] field) {
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
    public Long hdel(byte[] key, byte[]... field) {
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
    public Long hlen(byte[] key) {
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
    public Set<byte[]> hkeys(byte[] key) {
        Set<byte[]> result = null;
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
    public Collection<byte[]> hvals(byte[] key) {
        Collection<byte[]> result = null;
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
    public Map<byte[], byte[]> hgetAll(byte[] key) {
        Map<byte[], byte[]> result = null;
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
    public Long rpush(byte[] key, byte[]... args) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.rpush(key, args);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long lpush(byte[] key, byte[]... args) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lpush(key, args);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long llen(byte[] key) {
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
    public List<byte[]> lrange(byte[] key, long start, long end) {
        List<byte[]> result = null;
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
    public String ltrim(byte[] key, long start, long end) {
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
    public byte[] lindex(byte[] key, long index) {
        byte[] result = null;
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
    public String lset(byte[] key, long index, byte[] value) {
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
    public Long lrem(byte[] key, long count, byte[] value) {
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
    public byte[] lpop(byte[] key) {
        byte[] result = null;
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
    public byte[] rpop(byte[] key) {
        byte[] result = null;
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
    public Long sadd(byte[] key, byte[]... member) {
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
    public Set<byte[]> smembers(byte[] key) {
        Set<byte[]> result = null;
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
    public Long srem(byte[] key, byte[]... member) {
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
    public byte[] spop(byte[] key) {
        byte[] result = null;
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
    public Set<byte[]> spop(byte[] key, long count) {
        Set<byte[]> result = null;
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
    public Long scard(byte[] key) {
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
    public Boolean sismember(byte[] key, byte[] member) {
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
    public byte[] srandmember(byte[] key) {
        byte[] result = null;
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
    public List<byte[]> srandmember(byte[] key, int count) {
        List<byte[]> result = null;
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
    public Long strlen(byte[] key) {
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
    public Long zadd(byte[] key, double score, byte[] member) {
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
    public Long zadd(byte[] key, double score, byte[] member, ZAddParams params) {
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
    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers) {
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
    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers, ZAddParams params) {
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
    public Set<byte[]> zrange(byte[] key, long start, long end) {
        Set<byte[]> result = null;
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
    public Long zrem(byte[] key, byte[]... member) {
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
    public Double zincrby(byte[] key, double score, byte[] member) {
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
    public Double zincrby(byte[] key, double score, byte[] member, ZIncrByParams params) {
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
    public Long zrank(byte[] key, byte[] member) {
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
    public Long zrevrank(byte[] key, byte[] member) {
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
    public Set<byte[]> zrevrange(byte[] key, long start, long end) {
        Set<byte[]> result = null;
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
    public Set<Tuple> zrangeWithScores(byte[] key, long start, long end) {
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
    public Set<Tuple> zrevrangeWithScores(byte[] key, long start, long end) {
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
    public Long zcard(byte[] key) {
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
    public Double zscore(byte[] key, byte[] member) {
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
    public List<byte[]> sort(byte[] key) {
        List<byte[]> result = null;
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
    public List<byte[]> sort(byte[] key, SortingParams sortingParameters) {
        List<byte[]> result = null;
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
    public Long zcount(byte[] key, double min, double max) {
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
    public Long zcount(byte[] key, byte[] min, byte[] max) {
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
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max) {
        Set<byte[]> result = null;
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
    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max) {
        Set<byte[]> result = null;
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
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min) {
        Set<byte[]> result = null;
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
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count) {
        Set<byte[]> result = null;
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
    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min) {
        Set<byte[]> result = null;
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
    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max, int offset, int count) {
        Set<byte[]> result = null;
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
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count) {
        Set<byte[]> result = null;
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
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max) {
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
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min) {
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
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count) {
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
    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min, int offset, int count) {
        Set<byte[]> result = null;
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
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max) {
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
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min) {
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
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max, int offset, int count) {
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
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count) {
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
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min, int offset, int count) {
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
    public Long zremrangeByRank(byte[] key, long start, long end) {
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
    public Long zremrangeByScore(byte[] key, double start, double end) {
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
    public Long zremrangeByScore(byte[] key, byte[] start, byte[] end) {
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
    public Long zlexcount(byte[] key, byte[] min, byte[] max) {
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
    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max) {
        Set<byte[]> result = null;
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
    public Set<byte[]> zrangeByLex(byte[] key, byte[] min, byte[] max, int offset, int count) {
        Set<byte[]> result = null;
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
    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min) {
        Set<byte[]> result = null;
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
    public Set<byte[]> zrevrangeByLex(byte[] key, byte[] max, byte[] min, int offset, int count) {
        Set<byte[]> result = null;
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
    public Long zremrangeByLex(byte[] key, byte[] min, byte[] max) {
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
    public Long linsert(byte[] key, BinaryClient.LIST_POSITION where, byte[] pivot, byte[] value) {
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
    public Long lpushx(byte[] key, byte[]... arg) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.lpushx(key, arg);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long rpushx(byte[] key, byte[]... arg) {
        Long result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.rpushx(key, arg);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public List<byte[]> blpop(byte[] arg) {
        List<byte[]> result = null;
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
    public List<byte[]> brpop(byte[] arg) {
        List<byte[]> result = null;
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
    public Long del(byte[] key) {
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
    public byte[] echo(byte[] arg) {
        byte[] result = null;
        ShardedJedis shardedJedis = getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.echo(arg);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    @Override
    public Long move(byte[] key, int dbIndex) {
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
    public Long bitcount(byte[] key) {
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
    public Long bitcount(byte[] key, long start, long end) {
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
    public Long pfadd(byte[] key, byte[]... elements) {
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
    public long pfcount(byte[] key) {
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
    public Long geoadd(byte[] key, double longitude, double latitude, byte[] member) {
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
    public Long geoadd(byte[] key, Map<byte[], GeoCoordinate> memberCoordinateMap) {
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
    public Double geodist(byte[] key, byte[] member1, byte[] member2) {
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
    public Double geodist(byte[] key, byte[] member1, byte[] member2, GeoUnit unit) {
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
    public List<byte[]> geohash(byte[] key, byte[]... members) {
        List<byte[]> result = null;
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
    public List<GeoCoordinate> geopos(byte[] key, byte[]... members) {
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
    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit) {
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
    public List<GeoRadiusResponse> georadius(byte[] key, double longitude, double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
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
    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit) {
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
    public List<GeoRadiusResponse> georadiusByMember(byte[] key, byte[] member, double radius, GeoUnit unit, GeoRadiusParam param) {
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

    @Override
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor) {
        ScanResult<Map.Entry<byte[], byte[]>> result = null;
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
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor, ScanParams params) {
        ScanResult<Map.Entry<byte[], byte[]>> result = null;
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
    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor) {
        ScanResult<byte[]> result = null;
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
    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor, ScanParams params) {
        ScanResult<byte[]> result = null;
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
    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor) {
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
    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor, ScanParams params) {
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
}
