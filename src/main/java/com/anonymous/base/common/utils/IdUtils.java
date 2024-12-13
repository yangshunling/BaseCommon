package com.anonymous.base.common.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * <p>
 * IdUtils 序列号工具类
 * </p>
 *
 * @author Anonymous
 * @since 2024/12/13 19:36
 */
public class IdUtils {

    /**
     * 生成 UUID
     *
     * @return 通用唯一识别码
     */
    public static String createUUID() {
        return IdUtil.randomUUID();
    }

    /**
     * 生成 ObjectId
     *
     * @return MongoDB数据库的一种唯一ID生成策略
     */
    public static String createObjectId() {
        return IdUtil.objectId();
    }

    /**
     * 生成 SnowflakeId
     *
     * @param terminalID   终端ID
     * @param dataCenterID 数据中心ID
     * @return 雪花算法ID
     */
    public static String createSnowflake(long terminalID, long dataCenterID) {
        terminalID = terminalID >> 16 & 31;
        Snowflake snowflake = IdUtil.getSnowflake(terminalID, dataCenterID);
        return snowflake.nextIdStr();
    }
}
