package com.dhcc.car.dao.cardao;

import com.dhcc.car.model.car.Car;
import com.dhcc.car.model.car.CarUserInfo;
import com.dhcc.car.model.param.ParamDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 * ===>车辆管理持久化业务dao接口
 * company
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2018-03-20 15:55
 * @version V1.0.0
 */
@Repository
public interface CarDao {
    /**
     * 查询车辆信息
     *
     * @param param <code>查询条件</code>
     * @return <code> List<Car> </code>
     * @throws RuntimeException <code>异常信息</code>
     */
    List<CarUserInfo> findCarDao(ParamDTO param) throws RuntimeException;

    /**
     * 查询车辆状态
     *
     * @return <code> String</code>
     * @throws RuntimeException <code>异常信息</code>
     */
    String getCarDao() throws RuntimeException;

    /**
     * 查询车辆信息
     *
     * @param param <code>查询条件</code>
     * @return <code> List<CarUserInfo></code>
     * @throws RuntimeException <code>异常信息</code>
     */
    List<CarUserInfo> findCarUseInfoDao(ParamDTO param) throws RuntimeException;

    /**
     * 增加车辆信息功能
     *
     * @param msg <code>车辆信息</code>
     * @return <code>int</code>
     * @throws RuntimeException <code>异常信息</code>
     */
    int addCarDao(Car msg) throws RuntimeException;

    /**
     * 增加车辆使用信息
     *
     * @param id     <code>车辆编号</code>
     * @param status <code>状态</code>
     * @param uName  <code>使用者</code>
     * @param remark <code>说明</code>
     * @throws RuntimeException <code>sql执行异常</code>
     */
    void addCarUseInfoDao(@Param("id") String id, @Param("status") String status, @Param("rTime") String rTime, @Param("uName") String uName, @Param("remark") String remark) throws RuntimeException;

    /**
     * 删除车辆信息功能
     *
     * @param id <code>车辆id</code>
     * @return <code>int</code>
     * @throws RuntimeException <code>异常信息</code>
     */
    int deleteCarDao(@Param("id") String id) throws RuntimeException;

    /**
     * 更新车辆信息
     *
     * @param id     <code>车辆id</code>
     * @param status <code>状态</code>
     * @param remark <code>说明</code>
     * @return <code>int</code>
     * @throws RuntimeException <code>异常信息</code>
     */
    int updateCarDao(@Param("id") String id, @Param("status") String status, @Param("state") String state, @Param("remark") String remark) throws RuntimeException;

    /**
     * 更新车辆使用信息
     *
     * @param id     <code>车辆id</code>
     * @param status <code>状态</code>
     * @param rTime  <code>换车时间</code>
     * @return <code>int</code>
     * @throws RuntimeException <code>异常信息</code>
     */
    void updateCarUseInfoDao(@Param("id") String id, @Param("status") String status, @Param("rTime") String rTime, @Param("remark") String remark) throws RuntimeException;
}
