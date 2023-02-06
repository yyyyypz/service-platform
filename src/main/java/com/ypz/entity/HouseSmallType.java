package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("t_house_small_type")
public class HouseSmallType implements Serializable {
    private Integer id; // id主键

    private String name; // 名称

    private String remark; // 备注

    private Integer bigTypeId; // 大类id

    @TableField(select = false)
    private HouseBigType houseBigType;  // 所属房屋大类

    @TableField(select = false)
    private List<House> houses; // 房屋集合
}
