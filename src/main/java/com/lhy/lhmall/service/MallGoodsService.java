package com.lhy.lhmall.service;

import com.lhy.lhmall.entity.MallGoods;
import com.lhy.lhmall.util.PageQueryUtil;
import com.lhy.lhmall.util.PageResult;

import java.util.List;

public interface MallGoodsService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getMallGoodsPage(PageQueryUtil pageUtil);

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    String saveMallGoods(MallGoods goods);

    /**
     * 批量新增商品数据
     *
     * @param MallGoodsList
     * @return
     */
    void batchSaveMallGoods(List<MallGoods> MallGoodsList);

    /**
     * 修改商品信息
     *
     * @param goods
     * @return
     */
    String updateMallGoods(MallGoods goods);

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    MallGoods getMallGoodsById(Long id);

    /**
     * 批量修改销售状态(上架下架)
     *
     * @param ids
     * @return
     */
    Boolean batchUpdateSellStatus(Long[] ids,int sellStatus);

    /**
     * 商品搜索
     *
     * @param pageUtil
     * @return
     */
    PageResult searchMallGoods(PageQueryUtil pageUtil);
}
