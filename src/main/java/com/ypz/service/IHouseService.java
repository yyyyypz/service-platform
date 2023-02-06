package com.ypz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ypz.entity.House;

// 使用mybatis-plus继承IService指定泛型
public interface IHouseService extends IService<House> {
}
