package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_news")
@Data
public class News {
    private Integer id; // 编号

    private String name; // 新闻标题

    private String newsPic = "default.jpg"; // 新闻图片

    private String content; // 正文
}
