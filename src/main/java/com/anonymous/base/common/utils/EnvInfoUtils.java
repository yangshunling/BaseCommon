package com.anonymous.base.common.utils;

import cn.hutool.system.SystemUtil;

/**
 * <p>
 * EnvInfoUtils 环境信息
 * </p>
 *
 * @author Anonymous
 * @since 2025/1/2 13:13
 */
public class EnvInfoUtils {
    /**
     * 获取 Java Virtual Machine Specification 信息
     *
     * @return JVM Specification 信息
     */
    public static String getJvmSpecInfo() {
        return "JVM Specification 信息: " + SystemUtil.getJvmSpecInfo();
    }

    /**
     * 获取 Java Virtual Machine Implementation 信息
     *
     * @return JVM Implementation 信息
     */
    public static String getJvmInfo() {
        return "JVM Implementation 信息: " + SystemUtil.getJvmInfo();
    }

    /**
     * 获取 Java Specification 信息
     *
     * @return Java Specification 信息
     */
    public static String getJavaSpecInfo() {
        return "Java Specification 信息: " + SystemUtil.getJavaSpecInfo();
    }

    /**
     * 获取 Java Implementation 信息
     *
     * @return Java Implementation 信息
     */
    public static String getJavaInfo() {
        return "Java Implementation 信息: " + SystemUtil.getJavaInfo();
    }

    /**
     * 获取 Java 运行时信息
     *
     * @return Java 运行时信息
     */
    public static String getJavaRuntimeInfo() {
        return "Java 运行时信息: " + SystemUtil.getJavaRuntimeInfo();
    }

    /**
     * 获取操作系统信息
     *
     * @return 操作系统信息
     */
    public static String getOsInfo() {
        return "操作系统信息: " + SystemUtil.getOsInfo();
    }

    /**
     * 获取当前用户信息
     *
     * @return 用户信息
     */
    public static String getUserInfo() {
        return "用户信息: " + SystemUtil.getUserInfo();
    }

    /**
     * 获取当前主机的网络地址信息
     *
     * @return 主机网络地址信息
     */
    public static String getHostInfo() {
        return "主机网络地址信息: " + SystemUtil.getHostInfo();
    }

    /**
     * 获取 Java 运行时信息，包括内存总大小、已用大小、可用大小等
     *
     * @return 运行时信息
     */
    public static String getRuntimeInfo() {
        return "运行时信息: " + SystemUtil.getRuntimeInfo();
    }

    public static void main(String[] args) {
        System.out.println(getJvmSpecInfo());
        System.out.println(getJvmInfo());
        System.out.println(getJavaSpecInfo());
        System.out.println(getJavaInfo());
        System.out.println(getJavaRuntimeInfo());
        System.out.println(getOsInfo());
        System.out.println(getUserInfo());
        System.out.println(getHostInfo());
        System.out.println(getRuntimeInfo());
    }
}
