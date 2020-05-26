package com.lhy.lhmall.dao;

import com.lhy.lhmall.entity.MallOrder;
import com.lhy.lhmall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallOrderMapper {
    int deleteById(Long orderId);

    int insert(MallOrder record);

    int insertSelective(MallOrder record);

    MallOrder selectById(Long orderId);

    MallOrder selectByOrderNo(String orderNo);

    int updateByIdSelective(MallOrder record);

    int updateById(MallOrder record);

    List<MallOrder> findMallOrderList(PageQueryUtil pageUtil);

    int getTotalMallOrders(PageQueryUtil pageUtil);

    List<MallOrder> selectByIds(@Param("orderIds") List<Long> orderIds);

    int checkOut(@Param("orderIds") List<Long> orderIds);

    int closeOrder(@Param("orderIds") List<Long> orderIds, @Param("orderStatus") int orderStatus);

    int checkDone(@Param("orderIds") List<Long> asList);
}
