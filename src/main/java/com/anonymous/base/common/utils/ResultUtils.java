package com.anonymous.base.common.utils;

import com.anonymous.base.common.model.request.HttpResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Anonymous
 * @Description: ResultUtils 交互接口返回实体
 * @date: 2024/6/21 13:39
 */
public class ResultUtils {
    public static final int SUCCESS = 200;
    public static final int FAILED = 400;

    /**
     * 返回Object对象
     */
    public static HttpResponse object(Object object) {
        HttpResponse respond = new HttpResponse();
        respond.setErrorNo(SUCCESS);
        respond.setErrorInfo("success");
        respond.setData(object);
        return respond;
    }

    /**
     * 返回List列表
     */
    public static <T> HttpResponse list(List<T> list, long count) {
        HttpResponse respond = new HttpResponse();
        respond.setErrorNo(SUCCESS);
        respond.setErrorInfo("success");

        Map<String, Object> dataList = new HashMap<>(16);
        dataList.put("count", count);
        dataList.put("list", list);
        respond.setData(dataList);

        return respond;
    }

    /**
     * 返回成功信息
     */
    public static HttpResponse success() {
        HttpResponse respond = new HttpResponse();
        respond.setErrorNo(SUCCESS);
        respond.setErrorInfo("success");
        respond.setData(null);
        return respond;
    }

    /**
     * 返回错误信息
     */
    public static HttpResponse error(String message) {
        HttpResponse respond = new HttpResponse();
        respond.setErrorNo(FAILED);
        respond.setErrorInfo(message);
        respond.setData(null);
        return respond;
    }
}
