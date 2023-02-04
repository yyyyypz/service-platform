package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.Order;
import com.ypz.entity.OrderDetail;
import com.ypz.entity.ResponseResult;
import com.ypz.service.IOrderDetailService;
import com.ypz.service.IOrderService;
import com.ypz.utils.DateUtil;
import com.ypz.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/my/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @RequestMapping("/create")
    @Transactional // 开启事务主键
    public ResponseResult create(@RequestBody Order order, @RequestHeader(value = "token") String token) {
        System.out.println("order=" + order);
        System.out.println("token=" + token);
        // 根据token获取openid
        Claims claims = JwtUtils.validateJWT(token).getClaims();
        if (claims != null && claims.getId() != null) {
            String openid = claims.getId();
            // 保存订单到数据库之前进行数据封装
            order.setUserId(claims.getId()); // openid为userId
        }
        order.setOrderNo("YS" + DateUtil.getCurrentDateStr()); // 单据号
        order.setCreateDate(new Date()); // 单据创建日期
        // 获取单据详情
        OrderDetail[] orderDetails = order.getGoods();
        // 将订单保存到数据库
        orderService.save(order);
        // 遍历订单详情绑定和订单的主外键关系
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setMId(order.getId());
            orderDetailService.save(orderDetail);
        }
        // 返回订单号给前端
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("orderNo", order.getOrderNo());
        return ResponseResult.ok(resultMap);
    }


    @RequestMapping("/pay")
    public ResponseResult pay(@RequestBody String orderNo) {
        // 根据单据号查询订单
        Order order = orderService.getOne(new QueryWrapper<Order>().eq("orderNo", orderNo));
        // 如果单据不为空且单据状态为未支付才进行支付
        if (order != null && order.getStatus() == 1) {
            // 设置支付日期
            order.setPayDate(new Date());
            // 修改支付状态为已支付
            order.setStatus(2);
            // 对单据进行更新操作
            orderService.saveOrUpdate(order);
            // 返回成功标志
            return ResponseResult.ok("支付成功！");
        }
        return ResponseResult.error("支付失败，该单据已被支付或为查询到该订单，请检查！");
    }

}
