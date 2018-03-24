package com.dhcc.car.exception;

/**
 * description:
 * ===>系统访问数据库异常封装类
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-06 14:27
 * @version V1.0.0
 */
public class CarDataBaseException extends RuntimeException {

    private static final long serialVersionUID = 6472513404477125985L;

    public CarDataBaseException() {
        super();
    }

    public CarDataBaseException(String message) {
        super(message);
    }

    public CarDataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
