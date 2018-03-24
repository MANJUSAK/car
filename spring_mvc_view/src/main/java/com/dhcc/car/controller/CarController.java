package com.dhcc.car.controller;

import com.dhcc.car.model.car.Car;
import com.dhcc.car.model.param.ParamDTO;
import com.dhcc.car.model.result.Status;
import com.dhcc.car.model.statusenum.StatusEnum;
import com.dhcc.car.service.CarService;
import com.dhcc.car.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * description:
 * ===>车辆管理访问接口处理类
 * company
 *
 * @author manjusaka[manjusakachn@gmail.com] Created on 2018-03-20 15:58
 * @version V1.0.0
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service;

    /**
     * 查询车辆信息接口
     *
     * @param param <code>查询条件</code>
     * @param <T>   <code>泛型</code>
     * @return <code>T</code>
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @GetMapping("/find/car.htm")
    public <T> T findCarController(ParamDTO param) {
        try {
            return this.service.findCarService(param);
        } catch (Exception e) {
            e.printStackTrace();
            return (T) ResultUtil.status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 查询车辆使用信息接口
     *
     * @param param <code>查询条件</code>
     * @param <T>   <code>泛型</code>
     * @return <code>T</code>
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.GET)
    @GetMapping("/find/caruseinfo.htm")
    public <T> T findCarUseInfoController(ParamDTO param) {
        try {
            return this.service.findCarUseInfoService(param);
        } catch (Exception e) {
            e.printStackTrace();
            return (T) ResultUtil.status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

    /**
     * 增加车辆信息接口
     *
     * @param msg <code>车辆信息</code>
     * @return <code>Status</code>
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @PostMapping("/add/car.htm")
    public Status addCarController(Car msg) {
        try {
            return this.service.addCarService(msg);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 删除车辆信息接口
     *
     * @param id <code>车辆id</code>
     * @return <code>Status</code>
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @PostMapping("/del/car.htm")
    public Status deleteCarController(String id) {
        try {
            return this.service.deleteCarService(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }


    /**
     * 车辆出借/归还接口
     *
     * @param id     <code>车辆id</code>
     * @param status <code>车辆状态</code>
     * @return <code>Status</code>
     */
    @CrossOrigin(origins = "*", maxAge = 3600, methods = RequestMethod.POST)
    @PostMapping("/updeate/car.htm")
    public Status updateCarController(String id, String status, String uName, String remark, int type) {
        try {
            return this.service.updateCarService(id, uName, status, remark, type);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.status(StatusEnum.DATABASE_ERROR.getCODE(), StatusEnum.DATABASE_ERROR.getEXPLAIN());
        }
    }

}
