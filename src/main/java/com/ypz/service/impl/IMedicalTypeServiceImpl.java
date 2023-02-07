package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.MedicalType;
import com.ypz.mapper.MedicalTypeMapper;
import com.ypz.service.IMedicalTypeService;
import org.springframework.stereotype.Service;

// 使用mybatis-plus继承ServiceImpl指定mapper接口和实体，实现对应的service接口
@Service
public class IMedicalTypeServiceImpl extends ServiceImpl<MedicalTypeMapper, MedicalType> implements IMedicalTypeService {
}
