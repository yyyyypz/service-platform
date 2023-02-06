package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("t_house_big_type")
@Data
public class HouseBigType {
    private Integer id; // id主键

    private String name; // 分类名称

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @TableField(select = false)
    private List<HouseSmallType> smallTypeList; // 房屋小类集合
}
