package com.dhcc.car.service.impl;

import com.dhcc.car.dao.userdao.UserDao;
import com.dhcc.car.exception.CarDataBaseException;
import com.dhcc.car.exception.CarException;
import com.dhcc.car.model.result.Status;
import com.dhcc.car.model.statusenum.StatusEnum;
import com.dhcc.car.model.user.User;
import com.dhcc.car.service.UserService;
import com.dhcc.car.util.ResultUtil;
import com.dhcc.car.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * description:
 * ===>用户业务接口实现类，处理用户相关业务逻辑
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-06 10:00
 * @version V1.0.0
 */
@SuppressWarnings("ALL")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 时间格式
     */
    private final static String DATEFORMAT = "HHmmssSSS";

    /**
     * 用户登录业务逻辑处理接口实现方法
     *
     * @param userName <code>用户名</code>
     * @param passWord <code>密码</code>
     * @return <code>T</code>
     * @throws CarException <code>程序出现异常处理信息</code>
     */
    @Override
    public <T> T userLoginService(String userName, String passWord) throws CarException {
        User data = null;
        try {
           /* ValueOperations<String, Object> so = this.redisTemplate.opsForValue();
            data = (User) so.get(userName);
            if (null == data) {*/
            data = this.dao.userLoginDao(userName, passWord);
               /* if (data != null) {
                    setUserToRedis(data);
                }
            }*/
        } catch (RuntimeException e) {
            throw new CarDataBaseException("程序发生异常：" + e.getMessage(), e.getCause());
        }
        if (data != null) {
            return (T) ResultUtil.result(StatusEnum.SUCCESS.getCODE(), data);
        }
        return (T) ResultUtil.status(StatusEnum.NO_USER.getCODE(), StatusEnum.NO_USER.getEXPLAIN());
    }

    /**
     * 用户注册业务逻辑处理接口实现方法
     *
     * @param userDO <code>用户信息</code>
     * @return <code>Status</code>
     * @throws CarException <code>程序出现异常处理信息</code>
     */
    @Override
    public Status userRegisterService(User user) throws CarException {
        String uName = this.dao.checkUnameDao(user.getName());
        if (uName != null) {
            return ResultUtil.status(100404, "用户名已被注册");
        }
        int status = 0;
        String date = DateTimeFormatter.ofPattern(DATEFORMAT).format(LocalDateTime.now());
        user.setUserNo(UUIDUtil.getUUID().toString());
        try {
            status = this.dao.userRegisterDao(user);
        } catch (RuntimeException e) {
            throw new CarDataBaseException("程序发生异常：" + e.getMessage(), e.getCause());
        }
        if (status > 0) {
//            setUserToRedis(user);
            return ResultUtil.status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
        }
        return ResultUtil.status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
    }

    private void setUserToRedis(User user) {
        ValueOperations<String, Object> vo = this.redisTemplate.opsForValue();
        vo.set(user.getName(), user);
    }
}
