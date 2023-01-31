package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.SmallType;
import com.ypz.mapper.SmallTypeMapper;
import com.ypz.service.ISmallTypeService;
import org.springframework.stereotype.Service;

@Service
public class ISmallTypeServiceImpl extends ServiceImpl<SmallTypeMapper,SmallType> implements ISmallTypeService {
}
