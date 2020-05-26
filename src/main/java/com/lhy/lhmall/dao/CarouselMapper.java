package com.lhy.lhmall.dao;

import com.lhy.lhmall.entity.Carousel;
import com.lhy.lhmall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarouselMapper {
    int deleteById(Integer carouselId);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectById(Integer carouselId);

    int updateByIdSelective(Carousel record);

    int updateById(Carousel record);

    List<Carousel> findCarouselList(PageQueryUtil pageUtil);

    int getTotalCarousels(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

    List<Carousel> findCarouselsByNum(@Param("number") int number);
}
