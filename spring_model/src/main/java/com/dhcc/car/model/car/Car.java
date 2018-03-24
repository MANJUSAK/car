package com.dhcc.car.model.car;

import java.util.Objects;

/**
 * description:
 * ===>车辆信息实体
 * company
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-20 15:35
 * @version V1.0.0
 */
public class Car extends CarUserInfo {
    private static final long serialVersionUID = -4327908059429690043L;
    private Integer id;
    private String carNo;
    private String carPno;
    private String carPdate;
    private String status;
    private String cRemark;
    private String isNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarPno() {
        return carPno;
    }

    public void setCarPno(String carPno) {
        this.carPno = carPno;
    }

    public String getCarPdate() {
        return carPdate;
    }

    public void setCarPdate(String carPdate) {
        this.carPdate = carPdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }

    public String getIsNo() {
        return isNo;
    }

    public void setIsNo(String isNo) {
        this.isNo = isNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(carNo, car.carNo) &&
                Objects.equals(carPno, car.carPno) &&
                Objects.equals(carPdate, car.carPdate) &&
                Objects.equals(status, car.status) &&
                Objects.equals(cRemark, car.cRemark) &&
                Objects.equals(isNo, car.isNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, carNo, carPno, carPdate, status, cRemark, isNo);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", carNo='").append(carNo).append('\'');
        sb.append(", carPno='").append(carPno).append('\'');
        sb.append(", carPdate=").append(carPdate);
        sb.append(", status='").append(status).append('\'');
        sb.append(", cRemark='").append(cRemark).append('\'');
        sb.append(", isNo='").append(isNo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
