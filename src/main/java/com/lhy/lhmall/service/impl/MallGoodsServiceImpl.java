package com.lhy.lhmall.service.impl;

import com.lhy.lhmall.common.ServiceResultEnum;
import com.lhy.lhmall.controller.vo.MallSearchGoodsVO;
import com.lhy.lhmall.dao.MallGoodsMapper;
import com.lhy.lhmall.entity.MallGoods;
import com.lhy.lhmall.service.MallGoodsService;
import com.lhy.lhmall.util.BeanUtil;
import com.lhy.lhmall.util.PageQueryUtil;
import com.lhy.lhmall.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MallGoodsServiceImpl implements MallGoodsService {

    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    @Override
    public PageResult getMallGoodsPage(PageQueryUtil pageUtil) {
        List<MallGoods> goodsList = mallGoodsMapper.findMallGoodsList(pageUtil);
        int total = mallGoodsMapper.getTotalMallGoods(pageUtil);
        PageResult pageResult = new PageResult(goodsList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveMallGoods(MallGoods goods) {
        if (mallGoodsMapper.insertSelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public void batchSaveMallGoods(List<MallGoods> mallGoods) {
        if (!CollectionUtils.isEmpty(mallGoods)) {
            mallGoodsMapper.batchInsert(mallGoods);
        }
    }

    @Override
    public String updateMallGoods(MallGoods goods) {
        MallGoods temp = mallGoodsMapper.selectById(goods.getGoodsId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        goods.setUpdateTime(new Date());
        if (mallGoodsMapper.updateByIdSelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public MallGoods getMallGoodsById(Long id) {
        return mallGoodsMapper.selectById(id);
    }

    @Override
    public Boolean batchUpdateSellStatus(Long[] ids, int sellStatus) {
        return mallGoodsMapper.batchUpdateSellStatus(ids, sellStatus) > 0;
    }

    @Override
    public PageResult searchMallGoods(PageQueryUtil pageUtil) {
        List<MallGoods> goodsList = mallGoodsMapper.findMallGoodsListBySearch(pageUtil);
        int total = mallGoodsMapper.getTotalMallGoodsBySearch(pageUtil);
        List<MallSearchGoodsVO> MallSearchGoodsVOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(goodsList)) {
            MallSearchGoodsVOS = BeanUtil.copyList(goodsList, MallSearchGoodsVO.class);
            for (MallSearchGoodsVO MallSearchGoodsVO : MallSearchGoodsVOS) {
                String goodsName = MallSearchGoodsVO.getGoodsName();
                String goodsIntro = MallSearchGoodsVO.getGoodsIntro();
                // 字符串过长导致文字超出的问题
                if (goodsName.length() > 28) {
                    goodsName = goodsName.substring(0, 28) + "...";
                    MallSearchGoodsVO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 30) {
                    goodsIntro = goodsIntro.substring(0, 30) + "...";
                    MallSearchGoodsVO.setGoodsIntro(goodsIntro);
                }
            }
        }
        PageResult pageResult = new PageResult(MallSearchGoodsVOS, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }
}
