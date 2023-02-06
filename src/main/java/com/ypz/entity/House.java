package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ypz.utils.CustomDateTimeSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@TableName("t_house")
@Data
public class House {
    private Integer id; // 编号

    private String name; // 名称

    private BigDecimal price; // 价格

    private String housePic = "default.jpg"; // 房屋图片

    private String description; // 描述

    @TableField(select = false)  // 该字段不参与数据库查询
    private List<HouseSwiperImage> houseSwiperImages; // 房屋详情轮播图
}
