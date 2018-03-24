package com.dhcc.car.service;

import com.dhcc.car.exception.CarException;
import com.dhcc.car.model.result.Status;
import com.dhcc.car.model.user.User;

/**
 * description:
 * ===>用户业务接口，处理用户相关业务逻辑接口
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-06 9:57
 * @version V1.0.0
 */
public interface UserService {
    /**
     * 用户登录业务逻辑处理接口
     *
     * @param userName <code>用户名</code>
     * @param passWord <code>密码</code>
     * @param <T>      <code>泛型指数</code>
     * @return <code>T</code>
     * @throws CarException <code>程序出现异常处理信息</code>
     */
    <T> T userLoginService(String userName, String passWord) throws CarException;

    /**
     * 用户注册业务逻辑处理接口
     *
     * @param user <code>用户信息</code>
     * @return <code>Status</code>
     * @throws CarException <code>程序出现异常处理信息</code>
     */
    Status userRegisterService(User user) throws CarException;
}
