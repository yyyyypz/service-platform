package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.Admin;
import com.ypz.mapper.AdminMapper;
import com.ypz.service.IAdminService;
import org.springframework.stereotype.Service;

// 使用mybatis-plus继承ServiceImpl指定mapper接口和实体，实现对应的service接口
@Service
public class IAdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
}
