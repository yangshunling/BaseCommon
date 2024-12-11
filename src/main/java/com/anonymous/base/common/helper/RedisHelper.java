package com.anonymous.base.common.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description: RedisOperateHelper Redis操作工具类
 * @author : yangsl25774
 * @date: 2024/12/11 14:50
 */
@Service
public class RedisHelper {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置指定键的值，默认不设置过期时间。
     *
     * @param key 键
     * @param value 值
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置指定键的值，并设置过期时间。
     *
     * @param key 键
     * @param value 值
     * @param timeout 过期时间
     * @param unit 过期时间单位
     */
    public void set(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 获取指定键的值。
     *
     * @param key 键
     * @return 值，如果键不存在，则返回 null
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除指定的键。
     *
     * @param key 键
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 判断指定键是否存在。
     *
     * @param key 键
     * @return 如果键存在，返回 true，否则返回 false
     */
    public boolean exists(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * 向指定哈希键中设置字段的值。
     *
     * @param hashKey 哈希键
     * @param key 字段键
     * @param value 字段值
     */
    public void setHash(String hashKey, String key, Object value) {
        redisTemplate.opsForHash().put(hashKey, key, value);
    }

    /**
     * 获取指定哈希键中的字段值。
     *
     * @param hashKey 哈希键
     * @param key 字段键
     * @return 字段值，如果字段不存在，则返回 null
     */
    public Object getHash(String hashKey, String key) {
        return redisTemplate.opsForHash().get(hashKey, key);
    }

    /**
     * 删除指定哈希键中的字段。
     *
     * @param hashKey 哈希键
     * @param key 字段键
     */
    public void deleteHash(String hashKey, String key) {
        redisTemplate.opsForHash().delete(hashKey, key);
    }

    /**
     * 向指定列表中添加元素。
     *
     * @param key 列表键
     * @param value 要添加的值
     */
    public void setList(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 获取指定列表中索引位置的元素。
     *
     * @param key 列表键
     * @param index 索引位置
     * @return 列表中的元素，如果索引不存在，则返回 null
     */
    public Object getList(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 从指定列表中删除指定的值。
     *
     * @param key 列表键
     * @param value 要删除的值
     */
    public void removeListValue(String key, Object value) {
        redisTemplate.opsForList().remove(key, 0, value);
    }

    /**
     * 向指定集合中添加元素。
     *
     * @param key 集合键
     * @param value 要添加的值
     */
    public void setSet(String key, Object value) {
        redisTemplate.opsForSet().add(key, value);
    }

    /**
     * 获取指定集合中的所有元素。
     *
     * @param key 集合键
     * @return 集合中的所有元素
     */
    public Object getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 判断指定值是否存在于指定集合中。
     *
     * @param key 集合键
     * @param value 要检查的值
     * @return 如果集合中存在该值，则返回 true，否则返回 false
     */
    public boolean existsInSet(String key, Object value) {
        return Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(key, value));
    }

    /**
     * 获取指定键的过期时间。
     *
     * @param key 键
     * @return 键的过期时间，单位为秒。如果键不存在或没有设置过期时间，则返回 null
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 设置指定键的过期时间。
     *
     * @param key 键
     * @param timeout 过期时间
     * @param unit 过期时间单位
     */
    public void setExpire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }
}
