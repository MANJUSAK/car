package com.dhcc.car.dao.userdao;

import com.dhcc.car.model.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * description:
 * ===>用户数据持久化dao层接口，用户保存用户数据到数据库
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-06 10:02
 * @version V1.0.0
 */
@Repository
public interface UserDao {

    /**
     * 用户登录获取用户数据dao接口
     *
     * @param userName <code>用户名</code>
     * @param passWord <code>密码</code>
     * @return <code>userDO</code>
     * @throws RuntimeException sql执行异常
     */
    User userLoginDao(@Param("uName") String userName, @Param("pwd") String passWord) throws RuntimeException;

    /**
     * 检查用户名是否存在dao方法
     *
     * @param userName 用户名
     * @return <code>String</code>
     * @throws RuntimeException <code>sql执行异常</code>
     */
    String checkUnameDao(@Param("uName") String userName) throws RuntimeException;

    /**
     * 用户注册数据保存dao接口
     *
     * @param user <code>用户信息</code>
     * @return <code>0</code>或<code>1</code>
     * @throws RuntimeException <code>sql执行异常</code>
     */
    int userRegisterDao(User user) throws RuntimeException;

}
