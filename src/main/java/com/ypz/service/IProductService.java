package com.ypz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ypz.entity.Product;

// 使用mybatis-plus继承IService指定泛型（固定写法）
public interface IProductService extends IService<Product> {
}
