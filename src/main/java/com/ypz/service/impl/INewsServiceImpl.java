package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.News;
import com.ypz.mapper.NewsMapper;
import com.ypz.service.INewsService;
import org.springframework.stereotype.Service;

// 使用mybatis-plus继承ServiceImpl指定mapper接口和实体，实现对应的service接口
@Service
public class INewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {
}
