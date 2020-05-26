package com.lhy.lhmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MallIndex {
    //首页实体
    private Long configId;//商品id

    private String configName;//首页显示商品

    private Byte configType;//商品类型

    private Long goodsId;//商品名字

    private String redirectUrl;//重定向链接

    private Integer configRank;
    private Byte isDeleted;
}
