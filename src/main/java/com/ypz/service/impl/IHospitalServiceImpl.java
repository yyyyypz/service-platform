package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.Hospital;
import com.ypz.mapper.HospitalMapper;
import com.ypz.service.IHospitalService;
import org.springframework.stereotype.Service;

// 使用mybatis-plus继承ServiceImpl指定mapper接口和实体，实现对应的service接口
@Service
public class IHospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements IHospitalService {
}
