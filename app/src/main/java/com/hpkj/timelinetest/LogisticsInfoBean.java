package com.hpkj.timelinetest;

import java.io.Serializable;

/**
 * 物流信息 实体类
 */
public class LogisticsInfoBean  implements Serializable {
    /**
     * 物流信息
     */
    private String message;
    /**
     * 当前物流状态
     */
    private LogisticsStatus status;
    /**
     * 日期
     */
    private String date;
    /**
     * 时间
     */
    private String time;

    public LogisticsInfoBean(String message, LogisticsStatus status, String date, String time) {
        this.message = message;
        this.status = status;
        this.date = date;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LogisticsStatus getStatus() {
        return status;
    }

    public void setStatus(LogisticsStatus status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
