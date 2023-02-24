package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.House;
import com.ypz.entity.HouseSwiperImage;
import com.ypz.entity.ResponseResult;
import com.ypz.service.IHouseService;
import com.ypz.service.IHouseSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查看房源详情
 * @author ypz
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private IHouseService houseService;
    @Autowired
    private IHouseSwiperImageService houseSwiperImageService;

    @GetMapping("/queryHouseDetail")
    public ResponseResult queryHouseDetail(Integer id) {
        // 根据id查询
        House house = houseService.getById(id);
        // 根据房屋详情图片表和房屋表的主外键关系查询房屋图片，并且进行排序
        List<HouseSwiperImage> houseSwiperImages = houseSwiperImageService.list(new QueryWrapper<HouseSwiperImage>().eq("houseId", house.getId()).orderByAsc("sort"));
        // 封装图片信息
        house.setHouseSwiperImages(houseSwiperImages);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", house);
        return ResponseResult.ok(resultMap);
    }
}
