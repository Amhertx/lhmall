package com.lhy.lhmall.dao;

import com.lhy.lhmall.entity.MallGoods;
import com.lhy.lhmall.entity.StockNumDTO;
import com.lhy.lhmall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallGoodsMapper {
    int deleteById(Long goodsId);

    int insert(MallGoods record);

    int insertSelective(MallGoods record);

    MallGoods selectById(Long goodsId);

    int updateByIdSelective(MallGoods record);

    int updateByIdWithBLOBs(MallGoods record);

    int updateById(MallGoods record);

    List<MallGoods> findMallGoodsList(PageQueryUtil pageUtil);

    int getTotalMallGoods(PageQueryUtil pageUtil);

    List<MallGoods> selectByIds(List<Long> goodsIds);

    List<MallGoods> findMallGoodsListBySearch(PageQueryUtil pageUtil);

    int getTotalMallGoodsBySearch(PageQueryUtil pageUtil);

    int batchInsert(@Param("MallGoodsList") List<MallGoods> MallGoodsList);

    int updateStockNum(@Param("stockNumDTOS") List<StockNumDTO> stockNumDTOS);

    int batchUpdateSellStatus(@Param("orderIds")Long[] orderIds,@Param("sellStatus") int sellStatus);

}
