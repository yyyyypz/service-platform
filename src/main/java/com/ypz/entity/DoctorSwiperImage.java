package com.ypz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("t_doctor_swiper_image")
@Data
public class DoctorSwiperImage {
    private Integer id; // 编号

    private String image; // 图片名称

    private Integer sort; // 排列序号 从小到大排序

    private Integer doctorId; // 所属医生
}
