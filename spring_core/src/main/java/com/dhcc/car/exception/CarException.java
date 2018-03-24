package com.dhcc.car.exception;

/**
 * description:
 * ===>系统异常封装处理类
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-06 14:32
 * @version V1.0.0
 */
public class CarException extends Exception {

    private static final long serialVersionUID = -6479367093410787392L;

    public CarException() {
        super();
    }

    public CarException(String message) {
        super(message);
    }

    public CarException(String message, Throwable cause) {
        super(message, cause);
    }
}
