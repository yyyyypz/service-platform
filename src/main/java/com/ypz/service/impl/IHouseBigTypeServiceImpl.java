package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.HouseBigType;
import com.ypz.mapper.HouseBigTypeMapper;
import com.ypz.service.IHouseBigTypeService;
import org.springframework.stereotype.Service;

// 使用mybatis-plus继承ServiceImpl指定mapper接口和实体，实现对应的service接口
@Service
public class IHouseBigTypeServiceImpl extends ServiceImpl<HouseBigTypeMapper, HouseBigType> implements IHouseBigTypeService {
}
