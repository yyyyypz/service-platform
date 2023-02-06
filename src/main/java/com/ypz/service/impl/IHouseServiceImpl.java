package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.House;
import com.ypz.mapper.HouseMapper;
import com.ypz.service.IHouseService;
import org.springframework.stereotype.Service;

// 使用mybatis-plus继承ServiceImpl指定mapper接口和实体，实现对应的service接口
@Service
public class IHouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {
}
