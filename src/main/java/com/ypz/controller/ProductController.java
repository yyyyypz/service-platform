package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.Product;
import com.ypz.entity.ResponseResult;
import com.ypz.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  // restFul风格
@RequestMapping("/product")  // 指定模块访问前缀
public class ProductController {
    // 自动装配service层实体（控制反转）
    @Autowired
    private IProductService iProductService;

    @GetMapping("/querySwiper")
    public ResponseResult querySwiper() {
        // 查询轮播商品，根据升序排序
        List<Product> swiperProducts = iProductService.list(new QueryWrapper<Product>().eq("isSwiper", true).orderByAsc("swiperSort"));
        // 如果查询成功，把数据响应到前端
        if (swiperProducts.size() > 0 && swiperProducts != null) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("datas", swiperProducts);
            return ResponseResult.ok(resultMap);
        }
        return ResponseResult.error("轮播商品为空，请检查！");
    }
}
