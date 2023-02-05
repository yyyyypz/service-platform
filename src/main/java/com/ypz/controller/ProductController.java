package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypz.entity.Product;
import com.ypz.entity.ProductSwiperImage;
import com.ypz.entity.ResponseResult;
import com.ypz.service.IProductService;
import com.ypz.service.IProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    private IProductSwiperImageService iProductSwiperImageService;

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

    /**
     * 查询热卖商品
     *
     * @return
     */
    @GetMapping("/queryHotProduct")
    public ResponseResult queryHotProduct() {
//        // 分页条数，查询前8个热卖商品
//        Page<Product> page = new Page<>(0, 8);
//        // 查询条件，isHot表示是否为热卖商品，根据升序排序
//        QueryWrapper<Product> queryWrapper = new QueryWrapper<Product>().eq("isHot", true).orderByAsc();
//        // 所有查询条件汇总
//        Page<Product> pageQueryCondition = iProductService.page(page, queryWrapper);
//        // 调用查询方法
        Page<Product> pageQueryCondition = iProductService.page(new Page<Product>(0, 8), new QueryWrapper<Product>().eq("isHot", true).orderByAsc("hotDateTime"));
        List<Product> hotProducts = pageQueryCondition.getRecords();
        if (hotProducts != null && hotProducts.size() > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("datas", hotProducts);
            return ResponseResult.ok(map);
        }
        return ResponseResult.error("热卖商品为空，请检查！");
    }

    @GetMapping("/queryProductDetail")
    public ResponseResult queryDetail(Integer id) {
        // 根据id查询商品信息
        Product product = iProductService.getById(id);
        // 根据商品详情图片和商品的主外键关系查询商品图片，并且对图片进行排序
        List<ProductSwiperImage> productSwiperImages = iProductSwiperImageService.list(new QueryWrapper<ProductSwiperImage>().eq("productId", product.getId()).orderByAsc("sort"));
        // 封装图片信息
        product.setProductSwiperImages(productSwiperImages);
        Map<String, Object> map = new HashMap<>();
        // 将商品信息封装到map集合当中
        map.put("datas", product);
        // 响应
        return ResponseResult.ok(map);
    }

    @GetMapping("/search")
    public ResponseResult search(String queryParam) {
        // 根据商品名称模糊进行模糊查询
        List<Product> products = iProductService.list(new QueryWrapper<Product>().like("name", queryParam));
        // 创建map进行数据封装
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", products);
        // 将数据响应个前端
        return ResponseResult.ok(resultMap);
    }
}
