package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.Order;
import com.ypz.mapper.OrderMapper;
import com.ypz.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class IOrderImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
