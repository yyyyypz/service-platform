package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ypz.utils.CustomDateTimeSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("t_wxUserInfo")
@Data
public class WxUserInfo implements Serializable {

    private Integer id; // 用户编号

    private String openid; // 用户唯一标识

    private String nickName; // 用户昵称

    private String avatarUrl; // 用户头像图片的 URL

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date registerDate; // 注册日期

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    private Date lastLoginDate; // 最后登录日期

    @TableField(select = false, exist = false)
    private String code; // 微信用户code 前端传来的不参与数据库操作


}