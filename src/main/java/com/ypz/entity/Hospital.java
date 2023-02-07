package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("t_hospital")
@Data
public class Hospital {

    @TableId(type = IdType.AUTO)
    private Integer id; // 编号

    private String name; // 用户名

    @TableField(select = false)
    private List<MedicalType> medicalTypeList; // 商品小类集合
}
