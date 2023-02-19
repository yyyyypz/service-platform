package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.NewsType;
import com.ypz.mapper.NewsTypeMapper;
import com.ypz.service.INewsTypeService;
import org.springframework.stereotype.Service;

// 使用mybatis-plus继承ServiceImpl指定mapper接口和实体，实现对应的service接口
@Service
public class INewsTypeServiceImpl extends ServiceImpl<NewsTypeMapper, NewsType> implements INewsTypeService {
}
