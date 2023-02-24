package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.BigType;
import com.ypz.entity.Product;
import com.ypz.entity.ResponseResult;
import com.ypz.entity.SmallType;
import com.ypz.service.IBigTypeService;
import com.ypz.service.IProductService;
import com.ypz.service.ISmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品数据查询
 * @author ypz
 */
@RestController
@RequestMapping("/bigType")
public class BigTypeController {
    @Autowired
    private IBigTypeService iBigTypeService;

    @Autowired
    private ISmallTypeService iSmallTypeService;

    @Autowired
    private IProductService iProductService;

    @GetMapping("/queryBigType")
    public ResponseResult queryBigType() {
        List<BigType> bigTypeList = iBigTypeService.list();
        if (bigTypeList != null && bigTypeList.size() > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("datas", bigTypeList);
            return ResponseResult.ok(map);
        }
        return ResponseResult.error("商品大类为空，请检查！");
    }

    @GetMapping("/queryCategories")
    public ResponseResult queryCategories() {
        // 查询所有商品大类
        List<BigType> bigTypes = iBigTypeService.list();
        // 遍历商品大类
        for (BigType bigType : bigTypes) {
            // 根据商品大类和小类的主外键关系查询商品小类
            List<SmallType> smallTypes = iSmallTypeService.list(new QueryWrapper<SmallType>().eq("bigTypeId", bigType.getId()));
            // 将每个小类set到对应的大类当中
            bigType.setSmallTypeList(smallTypes);
            // 遍历商品小类，根据商品小类和商品的主外键关系插叙该小类下的所有商品
            for (SmallType smallType : smallTypes) {
                List<Product> products = iProductService.list(new QueryWrapper<Product>().eq("typeId", smallType.getId()));
                // 将所有商品set到商品小类集合当中
                smallType.setProductList(products);
            }
        }
        // 将查询到的数据封装到map当中
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", bigTypes);
        // 返回数据
        return ResponseResult.ok(resultMap);
    }
}
