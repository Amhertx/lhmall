package com.lhy.lhmall.service;

import com.lhy.lhmall.controller.vo.MallShoppingCarVO;
import com.lhy.lhmall.entity.MallShoppingCar;

import java.util.List;

public interface MallShoppingCarService {
    /**
     * 保存商品至购物车中
     *
     * @param MallShoppingCar
     * @return
     */
    String saveMallCar(MallShoppingCar MallShoppingCar);

    /**
     * 修改购物车中的属性
     *
     * @param MallShoppingCar
     * @return
     */
    String updateMallCar(MallShoppingCar MallShoppingCar);

    /**
     * 获取购物项详情
     *
     * @param MallShoppingCarId
     * @return
     */
    MallShoppingCar getMallCarById(Long MallShoppingCarId);

    /**
     * 删除购物车中的商品
     *
     * @param MallShoppingCarId
     * @return
     */
    Boolean deleteById(Long MallShoppingCarId);

    /**
     * 获取我的购物车中的列表数据
     *
     * @param MallUserId
     * @return
     */
    List<MallShoppingCarVO> getMyShoppingCars(Long MallUserId);
}
