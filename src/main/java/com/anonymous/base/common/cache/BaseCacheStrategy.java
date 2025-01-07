package com.anonymous.base.common.cache;

/**
 * <p>
 * CacheStrategy 内存缓存策略标准接口
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/27 13:46
 */
public interface BaseCacheStrategy<K, V> {

    /**
     * 向缓存中添加数据
     *
     * @param K 缓存的键
     * @param V 缓存的值
     */
    void put(String K, Object V);

    /**
     * 从缓存中获取数据
     *
     * @param K 缓存的键
     * @return 缓存中的值
     */
    V get(String K);

    /**
     * 检查缓存中是否包含某个键
     *
     * @param key 缓存的键
     * @return 是否包含该键
     */
    boolean containsKey(String key);

    /**
     * 获取缓存的大小
     *
     * @return 缓存的条目数量
     */
    long size();

    /**
     * 删除缓存中的数据
     *
     * @param key 缓存的键
     */
    void remove(K key);

    /**
     * 清空缓存
     */
    void clear();
}
