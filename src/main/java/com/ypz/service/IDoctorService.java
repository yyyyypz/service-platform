package com.ypz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ypz.entity.Doctor;

// 使用mybatis-plus继承IService指定泛型
public interface IDoctorService extends IService<Doctor> {
}
