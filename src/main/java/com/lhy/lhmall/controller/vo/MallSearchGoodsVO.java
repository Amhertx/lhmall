package com.lhy.lhmall.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 搜索列表页商品VO
 */
@Setter
@Getter
public class MallSearchGoodsVO implements Serializable {
    private Long goodsId;

    private String goodsName;

    private String goodsIntro;

    private String goodsCoverImg;

    private Integer sellingPrice;
}
