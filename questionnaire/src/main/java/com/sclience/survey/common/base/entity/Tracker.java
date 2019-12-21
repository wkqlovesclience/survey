package com.sclience.survey.common.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * TODO
 *
 * @author 王克强
 * @version 1.0
 * @since 2019-12-05 23:11:49
 */
@Entity
@Table(name = "tracker")
public class Tracker extends IdEntity{
    @Column(name = "data_type")
    private String dataType;
    @Column(name = "data_id")
    private String dataId;
    @Column(name = "operation")
    private String operation;
    @Column(name = "op_time")
    private Date optime = new Date();
    @Column(name = "login_name")
    private String loginName;

    public Tracker() {
    }

    public Tracker(String dataType, String dataId, String operation, Date optime, String loginName) {
        this.dataType = dataType;
        this.dataId = dataId;
        this.operation = operation;
        this.optime = optime;
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "dataType='" + dataType + '\'' +
                ", dataId='" + dataId + '\'' +
                ", operation='" + operation + '\'' +
                ", optime=" + optime +
                ", loginName='" + loginName + '\'' +
                '}';
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
