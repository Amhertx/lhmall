package com.lhy.lhmall.controller.vo;

import com.lhy.lhmall.entity.GoodsCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 搜索页分类数据VO
 */
@Getter
@Setter
public class SearchPageCategoryVO {
    private String firstLevelCategoryName;

    private List<GoodsCategory> secondLevelCategoryList;

    private String secondLevelCategoryName;

    private List<GoodsCategory> thirdLevelCategoryList;

    private String currentCategoryName;

}

