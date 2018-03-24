package com.dhcc.car.exception;

/**
 * description:
 * ===>系统业务异常封装处理类
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-06 14:29
 * @version V1.0.0
 */
public class CarApplicationException extends RuntimeException {

    private static final long serialVersionUID = 2915195718262235890L;

    public CarApplicationException(String message) {
        super(message);
    }

    public CarApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarApplicationException(Throwable cause) {
        super(cause);
    }
}
