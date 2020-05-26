package com.lhy.lhmall.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallShoppingCarMapper {
    int deleteByPrimaryKey(Long carId);

    int insert(MallShoppingCarMapper record);

    int insertSelective(MallShoppingCarMapper record);

    MallShoppingCarMapper selectByPrimaryKey(Long carId);

    MallShoppingCarMapper selectByUserIdAndGoodsId(@Param("MallUserId") Long MallUserId, @Param("goodsId") Long goodsId);

    List<MallShoppingCarMapper> selectByUserId(@Param("MallUserId") Long MallUserId, @Param("number") int number);

    int selectCountByUserId(Long MallUserId);

    int updateByPrimaryKeySelective(MallShoppingCarMapper record);

    int updateByPrimaryKey(MallShoppingCarMapper record);

    int deleteBatch(List<Long> ids);
}
