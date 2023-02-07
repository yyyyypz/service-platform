package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("t_medical_type")
public class MedicalType implements Serializable {
    private Integer id; // id主键

    private String name; // 名称

    private Integer hospitalId; // 医院id

    @TableField(select = false)
    private Hospital hospital;  // 所属医院

    @TableField(select = false)
    private List<Doctor> doctors; // 医生集合
}
