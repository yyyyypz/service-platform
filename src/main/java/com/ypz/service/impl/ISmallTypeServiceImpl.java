package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.SmallType;
import com.ypz.mapper.SmallTypeMapper;
import com.ypz.service.ISmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ISmallTypeServiceImpl extends ServiceImpl<SmallTypeMapper, SmallType> implements ISmallTypeService {
    @Autowired(required = false)
    private SmallTypeMapper smallTypeMapper;

    @Override
    public List<SmallType> list(Map<String, Object> map) {
        return smallTypeMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return smallTypeMapper.getTotal(map);
    }
}
