package com.ypz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ypz.entity.Product;

// 使用mybatis-plus继承baasMapper指定对应的实体（固定写法）
public interface ProductMapper extends BaseMapper<Product> {
}
