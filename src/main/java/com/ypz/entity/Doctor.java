package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@TableName("t_doctor")
@Data
public class Doctor {
    private Integer id; // 编号

    private String name; // 名称

    private BigDecimal price; // 价格

    private String doctorPic = "default.jpg"; // 医生图片

    private String description; // 描述

    @TableField(select = false)  // 该字段不参与数据库查询
    private List<DoctorSwiperImage> doctorSwiperImages; // 房屋详情轮播图
}
