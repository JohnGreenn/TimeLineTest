package com.hpkj.timelinetest;

/**
 * 物流信息当前状态
 */
public enum LogisticsStatus {
    /**
     *  一般提示语
     */
    TIPS,
    /**
     * 已下单
     */
    ORDERED,
    /**
     * 备货中
     */
    STOCK_UP ,
    /**
     * 已发货
     */
    DELIVERED,
    /**
     * 运输中
     */
    TRANSPORTING,
    /**
     * 已收货
     */
    RECEIVING
}
