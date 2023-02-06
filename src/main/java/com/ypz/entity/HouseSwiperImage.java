package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Yupz
 * 房屋详情轮播图片
 */
@TableName("t_house_swiper_image")
@Data
public class HouseSwiperImage {

    private Integer id; // 编号

    private String image; // 图片名称

    private Integer sort; // 排列序号 从小到大排序

    private Integer houseId; // 所属房屋
}
