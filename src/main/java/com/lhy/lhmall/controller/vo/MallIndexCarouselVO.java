package com.lhy.lhmall.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 首页轮播图VO
 */
@Getter
@Setter
public class MallIndexCarouselVO implements Serializable {
    private String carouselUrl;

    private String redirectUrl;

}
