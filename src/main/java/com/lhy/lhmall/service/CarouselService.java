package com.lhy.lhmall.service;

import com.lhy.lhmall.controller.vo.MallIndexCarouselVO;
import com.lhy.lhmall.entity.Carousel;
import com.lhy.lhmall.util.PageQueryUtil;
import com.lhy.lhmall.util.PageResult;

import java.util.List;

public interface CarouselService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCarouselPage(PageQueryUtil pageUtil);

    String saveCarousel(Carousel carousel);

    String updateCarousel(Carousel carousel);

    Carousel getCarouselById(Integer id);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回固定数量的轮播图对象(首页调用)
     *
     * @param number
     * @return
     */
    List<MallIndexCarouselVO> getCarouselsForIndex(int number);
}
