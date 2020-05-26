package com.lhy.lhmall.service;

import com.lhy.lhmall.controller.vo.MallIndexGoodsVO;
import com.lhy.lhmall.entity.MallIndex;
import com.lhy.lhmall.util.PageQueryUtil;
import com.lhy.lhmall.util.PageResult;

import java.util.List;

public interface MallIndexService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    String saveMallIndex(MallIndex mallIndex);

    String updateMallIndex(MallIndex mallIndex);

    MallIndex getMallIndexById(Long id);

    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     *
     * @param number
     * @return
     */
    List<MallIndexGoodsVO> getConfigGoodsesForIndex(int configType, int number);

    Boolean deleteBatch(Long[] ids);
}
