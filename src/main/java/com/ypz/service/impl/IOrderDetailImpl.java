package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.OrderDetail;
import com.ypz.mapper.OrderDetailMapper;
import com.ypz.service.IOrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class IOrderDetailImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {
}
