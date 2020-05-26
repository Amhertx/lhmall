package com.lhy.lhmall.service.impl;

import com.lhy.lhmall.common.ServiceResultEnum;
import com.lhy.lhmall.controller.vo.MallIndexGoodsVO;
import com.lhy.lhmall.dao.MallGoodsMapper;
import com.lhy.lhmall.dao.MallIndexMapper;
import com.lhy.lhmall.entity.MallGoods;
import com.lhy.lhmall.entity.MallIndex;
import com.lhy.lhmall.service.MallIndexService;
import com.lhy.lhmall.util.BeanUtil;
import com.lhy.lhmall.util.PageQueryUtil;
import com.lhy.lhmall.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MallIndexServiceImpl implements MallIndexService {

    @Autowired
    private MallIndexMapper mallIndexMapper;
    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    @Override
    public PageResult getConfigsPage(PageQueryUtil pageUtil) {
        List<MallIndex> mallIndexList = mallIndexMapper.findMallIndexList(pageUtil);
        int total = mallIndexMapper.getTotalMallIndex(pageUtil);
        PageResult pageResult = new PageResult(mallIndexList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveMallIndex(MallIndex mallIndex) {
        //判断是否存在该商品
        if (mallIndexMapper.insertSelective(mallIndex) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateMallIndex(MallIndex mallIndex) {
        //判断是否存在该商品
        MallIndex mallIndex1 = mallIndexMapper.selectById(mallIndex.getConfigId());
        if (mallIndex1 == null) {
            //返回数据不存在
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (mallIndexMapper.updateByIdSelective(mallIndex) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public MallIndex getMallIndexById(Long id) {
        return null;
    }

    @Override
    public List<MallIndexGoodsVO> getConfigGoodsesForIndex(int configType, int number) {
        List<MallIndexGoodsVO> mallIndexGoodsVOS = new ArrayList<>(number);
        List<MallIndex> mallIndices = mallIndexMapper.findMallIndexByTypeAndNum(configType, number);
        if (!CollectionUtils.isEmpty(mallIndices)) {
            //取出所有的goodsId
            List<Long> goodsId = mallIndices.stream().map(MallIndex::getConfigId).collect(Collectors.toList());
            List<MallGoods> mallGoods = mallGoodsMapper.selectByIds(goodsId);
            mallIndexGoodsVOS = BeanUtil.copyList(mallGoods, MallIndexGoodsVO.class);

            for (MallIndexGoodsVO mallIndexGoodsVO : mallIndexGoodsVOS) {
                String goodsName = mallIndexGoodsVO.getGoodsName();
                String goodsIntro = mallIndexGoodsVO.getGoodsIntro();
                //字符串过长导致文字超出的问题
                if (goodsName.length() > 30) {
                    goodsName = goodsName.substring(0, 30) + "...";
                    mallIndexGoodsVO.setGoodsName(goodsName);
                }
                if (goodsIntro.length() > 22) {
                    goodsIntro = goodsIntro.substring(0, 22) + "...";
                    mallIndexGoodsVO.setGoodsIntro(goodsIntro);
                }
            }
        }
        return mallIndexGoodsVOS;
    }

    @Override
    public Boolean deleteBatch(Long[] ids) {
        if (ids.length < 1) {
            return false;
        }
        //删除数据
        return mallIndexMapper.deleteBatch(ids) > 0;
    }
}
