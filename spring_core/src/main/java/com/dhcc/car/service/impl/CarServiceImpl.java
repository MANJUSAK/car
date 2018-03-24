package com.dhcc.car.service.impl;

import com.dhcc.car.dao.cardao.CarDao;
import com.dhcc.car.exception.CarException;
import com.dhcc.car.model.car.Car;
import com.dhcc.car.model.car.CarUserInfo;
import com.dhcc.car.model.param.ParamDTO;
import com.dhcc.car.model.result.Status;
import com.dhcc.car.model.statusenum.StatusEnum;
import com.dhcc.car.service.CarService;
import com.dhcc.car.util.ResultUtil;
import com.dhcc.car.util.UUIDUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * description:
 * ===>车辆管理业务接口实现类
 * company
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-20 15:39
 * @version V1.0.0
 */
@SuppressWarnings("ALL")
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao dao;
    /**
     * 时间格式
     */
    private final static String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 查询车辆使用信息
     *
     * @param param <code>查询条件</code>
     * @return <code>T</code>
     * @throws CarException <code>异常信息</code>
     */
    @Override
    public <T> T findCarUseInfoService(ParamDTO param) throws CarException {
        try {
            Page<T> pages = PageHelper.startPage(param.getPage(), param.getTotal());
            List<CarUserInfo> list = this.dao.findCarUseInfoDao(param);
            if (list.size() > 0) {
                PageInfo<CarUserInfo> data = new PageInfo<CarUserInfo>(list);
                return (T) ResultUtil.result(0, data);
            }
            return (T) ResultUtil.status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
        } catch (RuntimeException e) {
            throw new CarException("sql执行异常" + e.getMessage(), e.getCause());
        }
    }

    /**
     * 查询车辆信息
     *
     * @param param <code>查询条件</code>
     * @return <code>T</code>
     * @throws CarException <code>异常信息</code>
     */
    @Override
    public <T> T findCarService(ParamDTO param) throws CarException {
        try {
            Page<T> pages = PageHelper.startPage(param.getPage(), param.getTotal());
            List<CarUserInfo> list = this.dao.findCarDao(param);
            if (list.size() > 0) {
                PageInfo<CarUserInfo> data = new PageInfo<CarUserInfo>(list);
                return (T) ResultUtil.result(0, data);
            }
            return (T) ResultUtil.status(StatusEnum.NO_DATA.getCODE(), StatusEnum.NO_DATA.getEXPLAIN());
        } catch (RuntimeException e) {
            throw new CarException("sql执行异常" + e.getMessage(), e.getCause());
        }
    }

    /**
     * 增加车辆信息功能
     *
     * @param msg <code>车辆信息</code>
     * @return <code>Status</code>
     * @throws CarException <code>异常信息</code>
     */
    @Override
    public Status addCarService(Car msg) throws CarException {
        String strdate = null;
        msg.setCarNo(UUIDUtil.getUUID().toString());
        msg.setStatus("1");
        msg.setIsNo("0");
        try {

            int result = this.dao.addCarDao(msg);
            if (result > 0) {
                return ResultUtil.status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            }
            return ResultUtil.status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        } catch (RuntimeException e) {
            throw new CarException("sql执行异常" + e.getMessage(), e.getCause());
        }
    }

    /**
     * 删除车辆信息功能
     *
     * @param id <code>车辆id</code>
     * @return <code>Status</code>
     * @throws CarException <code>异常信息</code>
     */
    @Override
    public Status deleteCarService(String id) throws CarException {
        try {
            int result = this.dao.deleteCarDao(id);
            if (result > 0) {
                return ResultUtil.status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
            }
            return ResultUtil.status(StatusEnum.DEFEAT.getCODE(), StatusEnum.DEFEAT.getEXPLAIN());
        } catch (RuntimeException e) {
            throw new CarException("sql执行异常" + e.getMessage(), e.getCause());
        }
    }

    /**
     * 车辆出借/归还功能
     *
     * @param id     <code>车辆id</code>
     * @param status <code>车辆状态</code>
     * @return <code>Status</code>
     * * @param type   <code>操作状态（0为出借/1为归还）</code>
     * @throws CarException <code>异常信息</code>
     */
    @Override
    public Status updateCarService(String id, String uName, String status, String remark, int type) throws CarException {
        int result = 0;
        switch (type) {
            case 0:
                try {
                    result = this.dao.updateCarDao(id, status, "1", remark);
                } catch (RuntimeException e) {
                    throw new CarException("sql执行异常" + e.getMessage(), e.getCause());
                }
                if (result > 0) {
                    String date = DateTimeFormatter.ofPattern(DATEFORMAT).format(LocalDateTime.now());
                    this.dao.addCarUseInfoDao(id, "1", date, "admin", remark);
                    return ResultUtil.status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                }
                return ResultUtil.status(10300, "该车处于使用状态");
            case 1:
                try {
                    result = this.dao.updateCarDao(id, "1", "2", remark);
                    if (result > 0) {
                        String strdate = DateTimeFormatter.ofPattern(DATEFORMAT).format(LocalDateTime.now());
                        this.dao.updateCarUseInfoDao(id, status, strdate, remark);
                        return ResultUtil.status(StatusEnum.SUCCESS.getCODE(), StatusEnum.SUCCESS.getEXPLAIN());
                    }
                    return ResultUtil.status(10300, "该车处于空闲状态");
                } catch (RuntimeException e) {
                    throw new CarException("sql执行异常" + e.getMessage(), e.getCause());
                }
            default:
                return ResultUtil.status(StatusEnum.NO_PARAM.getCODE(), StatusEnum.NO_PARAM.getEXPLAIN());
        }
    }
}
