package com.dhcc.car.model.base;

import java.io.Serializable;
import java.util.Objects;

/**
 * description:
 * ===>系统实体基类，所有实体(xxDO)都必须继承本类
 * company：
 *
 * @author dhcc[manjusakachn@gmail.com] Created on 2018-03-06 10:04
 * @version V1.0.0
 */
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -4324790805949690043L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 版本号默认为0
     */
    private Integer version = 0;
    /**
     * 状态 StatusEnum
     */
    private String status = "0";
    /**
     * 创建人
     */
    private String creater = "0";
    /**
     * 创建时间
     */
    private String createTime = "0";
    /**
     * 修改人
     */
    private String editor = "0";
    /**
     * 修改时间
     */
    private String editTime = "0";
    /**
     * 描述
     */
    private String remark = "0";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseDO)) {
            return false;
        }
        BaseDO baseDO = (BaseDO) o;
        return Objects.equals(id, baseDO.id) &&
                Objects.equals(version, baseDO.version) &&
                Objects.equals(status, baseDO.status) &&
                Objects.equals(creater, baseDO.creater) &&
                Objects.equals(createTime, baseDO.createTime) &&
                Objects.equals(editor, baseDO.editor) &&
                Objects.equals(editTime, baseDO.editTime) &&
                Objects.equals(remark, baseDO.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, version, status, creater, createTime, editor, editTime, remark);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseDO{");
        sb.append("id=").append(id);
        sb.append(", version=").append(version);
        sb.append(", status='").append(status).append('\'');
        sb.append(", creater='").append(creater).append('\'');
        sb.append(", createTime='").append(createTime).append('\'');
        sb.append(", editor='").append(editor).append('\'');
        sb.append(", editTime='").append(editTime).append('\'');
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
