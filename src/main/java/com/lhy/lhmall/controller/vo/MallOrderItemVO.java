package com.lhy.lhmall.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 订单详情页页面订单项VO
 */
@Setter
@Getter
public class MallOrderItemVO implements Serializable {
    private Long goodsId;

    private Integer goodsCount;

    private String goodsName;

    private String goodsCoverImg;

    private Integer sellingPrice;
}
