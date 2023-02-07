package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.Doctor;
import com.ypz.mapper.DoctorMapper;
import com.ypz.service.IDoctorService;
import org.springframework.stereotype.Service;

// 使用mybatis-plus继承ServiceImpl指定mapper接口和实体，实现对应的service接口
@Service
public class IDoctorServiceImpl extends ServiceImpl<DoctorMapper, Doctor> implements IDoctorService {
}
