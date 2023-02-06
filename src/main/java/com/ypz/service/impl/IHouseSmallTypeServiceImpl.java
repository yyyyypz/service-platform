package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.HouseSmallType;
import com.ypz.mapper.HouseSmallTypeMapper;
import com.ypz.service.IHouseSmallTypeService;
import org.springframework.stereotype.Service;

// 使用mybatis-plus继承ServiceImpl指定mapper接口和实体，实现对应的service接口
@Service
public class IHouseSmallTypeServiceImpl extends ServiceImpl<HouseSmallTypeMapper, HouseSmallType> implements IHouseSmallTypeService {
}
