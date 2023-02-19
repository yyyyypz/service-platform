package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@TableName("t_news_type")
@Data
public class NewsType {
    private Integer id; // id主键

    private String name; // 名称

    @TableField(select = false)
    private List<News> news; // 新闻集合
}
