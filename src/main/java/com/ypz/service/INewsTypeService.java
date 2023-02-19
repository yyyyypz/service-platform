package com.ypz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ypz.entity.NewsType;

// 使用mybatis-plus继承IService指定泛型
public interface INewsTypeService extends IService<NewsType> {
}
