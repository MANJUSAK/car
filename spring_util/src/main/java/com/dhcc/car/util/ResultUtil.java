package com.dhcc.car.util;

import com.dhcc.car.model.result.Result;
import com.dhcc.car.model.result.Status;

/**
 * description:
 * ===>结果集封装工具类
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-06 14:52
 * @version V1.0.0
 */
public class ResultUtil {
    /**
     * 用于查询数据返回结果集封装方法
     *
     * @param errorCode <code>状态码</code>
     * @param data      <code>数据</code>
     * @return <code>Result</code>
     */
    public static Result result(int errorCode, Object data) {
        return new Result(errorCode, data);
    }

    /**
     * 用于提示性业务方法返回结果封装方法
     *
     * @param errorCode <code>状态码</code>
     * @param msg       <code>描述</code>
     * @return <code>Result</code>
     */
    public static Status status(int errorCode, String msg) {
        return new Status(errorCode, msg);
    }
}
