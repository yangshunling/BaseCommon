package com.anonymous.base.common.helper;

import com.anonymous.base.common.cache.FIFOCacheStrategy;
import com.anonymous.base.common.cache.LFUCacheStrategy;
import com.anonymous.base.common.cache.LRUCacheStrategy;
import com.anonymous.base.common.cache.TimedCacheStrategy;

/**
 * <p>
 * BaseCacheHelper 内存缓存工具类
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/27 20:14
 */
public class BaseCacheHelper {

    /**
     * FIFO缓存策略
     */
    private static FIFOCacheStrategy fifoCacheStrategy;

    /**
     * LFU缓存策略
     */
    private static LFUCacheStrategy lfuCacheStrategy;

    /**
     * LRU缓存策略
     */
    private static LRUCacheStrategy lruCacheStrategy;

    /**
     * Timed缓存策略
     */
    private static TimedCacheStrategy timedCacheStrategy;

    /**
     * 获取FIFO缓存策略
     *
     * @param maxSize 缓存最大容量
     * @return FIFO对象
     */
    public static FIFOCacheStrategy getFIFOCache(int... maxSize) {
        if (fifoCacheStrategy == null) {
            int size = (maxSize.length > 0) ? maxSize[0] : 100;
            fifoCacheStrategy = new FIFOCacheStrategy(size);
        }
        return fifoCacheStrategy;
    }

    /**
     * 获取LFU缓存策略
     *
     * @param maxSize 缓存最大容量
     * @return LFU对象
     */
    public static LFUCacheStrategy getLFUCache(int... maxSize) {
        if (lfuCacheStrategy == null) {
            int size = (maxSize.length > 0) ? maxSize[0] : 100;
            lfuCacheStrategy = new LFUCacheStrategy(size);
        }
        return lfuCacheStrategy;
    }

    /**
     * 获取LRU缓存策略
     *
     * @param maxSize 缓存最大容量
     * @return LRU对象
     */
    public static LRUCacheStrategy getLRUCache(int... maxSize) {
        if (lruCacheStrategy == null) {
            int size = (maxSize.length > 0) ? maxSize[0] : 100;
            lruCacheStrategy = new LRUCacheStrategy(size);
        }
        return lruCacheStrategy;
    }


    /**
     * 获取Timed缓存策略
     *
     * @param maxSize 缓存最大容量
     * @return Timed对象
     */
    public static TimedCacheStrategy getTimeCache(int... maxSize) {
        if (timedCacheStrategy == null) {
            int size = (maxSize.length > 0) ? maxSize[0] : 100;
            timedCacheStrategy = new TimedCacheStrategy(size);
        }
        return timedCacheStrategy;
    }
}
