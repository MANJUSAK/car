package com.dhcc.car.service;

import com.dhcc.car.exception.CarException;
import com.dhcc.car.model.param.ParamDTO;
import com.dhcc.car.model.car.Car;
import com.dhcc.car.model.result.Status;

/**
 * description:
 * ===>车辆管理业务接口
 * company
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-20 15:39
 * @version V1.0.0
 */
public interface CarService {
    /**
     * 查询车辆使用信息
     *
     * @param param <code>查询条件</code>
     * @param <T>   <code>泛型</code>
     * @return <code>T</code>
     * @throws CarException <code>异常信息</code>
     */
    <T> T findCarUseInfoService(ParamDTO param) throws CarException;

    /**
     * 查询车辆信息
     *
     * @param param <code>查询条件</code>
     * @param <T>   <code>泛型</code>
     * @return <code>T</code>
     * @throws CarException <code>异常信息</code>
     */
    <T> T findCarService(ParamDTO param) throws CarException;

    /**
     * 增加车辆信息功能
     *
     * @param msg <code>车辆信息</code>
     * @return <code>Status</code>
     * @throws CarException <code>异常信息</code>
     */
    Status addCarService(Car msg) throws CarException;

    /**
     * 删除车辆信息功能
     *
     * @param id <code>车辆id</code>
     * @return <code>Status</code>
     * @throws CarException <code>异常信息</code>
     */
    Status deleteCarService(String id) throws CarException;

    /**
     * 车辆出借/归还功能
     *
     * @param id     <code>车辆id</code>
     * @param status <code>车辆状态</code>
     * @param uName  <code>使用者</code>
     * @param remark <code>说明</code>
     * @param type   <code>操作状态（0为出借/1为归还）</code>
     * @return <code>Status</code>
     * @throws CarException <code>异常信息</code>
     */
    Status updateCarService(String id, String uName, String status, String remark, int type) throws CarException;
}
