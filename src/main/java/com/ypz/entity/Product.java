package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ypz.utils.CustomDateTimeSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@TableName("t_product")
@Data
public class Product {
    private Integer id; // 编号

    private String name; // 名称

    private BigDecimal price; // 价格

    private String productIntroImgs; // 商品介绍图片

    private String productParaImgs;  // 商品规格参数图片

    private Integer stock; // 库存

    private String proPic="default.jpg"; // 商品图片

    private boolean isHot=false; // 是否热门推荐商品

    private boolean isSwiper=false; // 是否轮播图片商品

    private Integer swiperSort=0; // 轮播排序

    private String swiperPic="default.jpg"; // 商品轮播图片

    private String description; // 描述

    @JsonSerialize(using= CustomDateTimeSerializer.class)
    private Date hotDateTime; // 设置热门推荐日期时间

}
