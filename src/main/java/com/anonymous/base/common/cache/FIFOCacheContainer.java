package com.anonymous.base.common.cache;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import com.anonymous.base.common.base.BaseCacheContainer;

/**
 * <p>
 * FIFOCacheStrategy 【先入先出】缓存策略
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/27 13:55
 */
public class FIFOCacheContainer<K, V> implements BaseCacheContainer<K, V> {

    /**
     * FIFO 缓存实例
     */
    private final Cache<K, V> fifoCache;

    /**
     * 构造函数，初始化 FIFO 缓存。
     *
     * @param maxSize 缓存的最大容量
     */
    public FIFOCacheContainer(int maxSize) {
        fifoCache = CacheUtil.newFIFOCache(maxSize);
    }

    /**
     * 向缓存中添加一个键值对。
     * 如果缓存已满，将会移除最早添加的元素。
     *
     * @param key   缓存的键
     * @param value 缓存的值
     */
    @Override
    public void put(K key, V value) {
        fifoCache.put(key, value);
    }

    /**
     * 从缓存中获取指定键的值。
     *
     * @param key 缓存的键
     * @return 如果缓存中存在该键，则返回对应的值；否则返回 null
     */
    @Override
    public V get(K key) {
        return fifoCache.get(key);
    }

    /**
     * 检查缓存中是否包含指定的键。
     *
     * @param key 缓存的键
     * @return 如果缓存中包含该键，返回 true；否则返回 false
     */
    @Override
    public boolean containsKey(K key) {
        return fifoCache.containsKey(key);
    }

    /**
     * 获取缓存中存储的元素个数。
     *
     * @return 当前缓存中元素的数量
     */
    @Override
    public long size() {
        return fifoCache.size();
    }

    /**
     * 从缓存中移除指定键的值。
     *
     * @param key 缓存的键
     */
    @Override
    public void remove(K key) {
        fifoCache.remove(key);
    }

    /**
     * 清空缓存中的所有数据。
     */
    @Override
    public void clear() {
        fifoCache.clear();
    }
}
