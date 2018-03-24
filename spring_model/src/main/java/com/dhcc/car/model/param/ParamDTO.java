package com.dhcc.car.model.param;

/**
 * description:
 * ===>参数辅助实体类
 * company
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-20 15:49
 * @version V1.0.0
 */
public class ParamDTO {
    private int page;
    private int total;
    private String isNo;
    private String uName;
    private String status;
    private String carid;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getIsNo() {
        return isNo;
    }

    public void setIsNo(String isNo) {
        this.isNo = isNo;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }
}
