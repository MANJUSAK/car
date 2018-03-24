package com.dhcc.car.model.car;

import java.io.Serializable;
import java.util.Objects;

/**
 * description:
 * ===>车辆使用信息
 * company
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-20 15:37
 * @version V1.0.0
 */
public class CarUserInfo implements Serializable {
    private static final long serialVersionUID = -4327908059690043L;
    private String carId;
    private String userName;
    private String bTime;
    private String rTime;
    private String cuRemark;
    private String cuStatus;


    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getbTime() {
        return bTime;
    }

    public void setbTime(String bTime) {
        this.bTime = bTime;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    public void setCuRemark(String cuRemark) {
        this.cuRemark = cuRemark;
    }

    public String getCuRemark() {
        return cuRemark;
    }

    public String getCuStatus() {
        return cuStatus;
    }

    public void setCuStatus(String cuStatus) {
        this.cuStatus = cuStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarUserInfo)) return false;
        CarUserInfo that = (CarUserInfo) o;
        return Objects.equals(carId, that.carId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(bTime, that.bTime) &&
                Objects.equals(rTime, that.rTime) &&
                Objects.equals(cuRemark, that.cuRemark) &&
                Objects.equals(cuStatus, that.cuStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carId, userName, bTime, rTime, cuRemark, cuStatus);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarUserInfo{");
        sb.append("carId='").append(carId).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", bTime='").append(bTime).append('\'');
        sb.append(", rTime='").append(rTime).append('\'');
        sb.append(", cuRemark='").append(cuRemark).append('\'');
        sb.append(", cuStatus='").append(cuStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
