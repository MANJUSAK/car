package com.dhcc.car.controller;

import com.dhcc.car.model.result.Status;
import com.dhcc.car.model.statusenum.StatusEnum;
import com.dhcc.car.model.user.User;
import com.dhcc.car.service.UserService;
import com.dhcc.car.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 * ===>用户访问接口处理、视图处理业务类
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-06 9:45
 * @version V1.0.0
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;


    /**
     * 用户登录接口
     *
     * @param userName <code>用户名</code>
     * @param passWord <code>密码</code>
     * @param <T>      <code>泛型指数</code>
     * @return <code>T</code>
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @GetMapping("/login.htm")
    public <T> T userLoginController(@RequestParam String uName, @RequestParam String pwd) {
        try {
            return this.service.userLoginService(uName, pwd);
        } catch (Exception e) {
            e.printStackTrace();
            return (T) ResultUtil.status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }

    }

    /**
     * 用户注册接口
     *
     * @param userDO <code>用户数据</code>
     * @return <code>Status</code>
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @PostMapping("/register.htm")
    public Status userRegisterController(User user) {
        try {
            return this.service.userRegisterService(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

}
