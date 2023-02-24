package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.House;
import com.ypz.entity.HouseBigType;
import com.ypz.entity.HouseSmallType;
import com.ypz.entity.ResponseResult;
import com.ypz.service.IHouseBigTypeService;
import com.ypz.service.IHouseService;
import com.ypz.service.IHouseSmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/houseBigType")
public class HouseBigTypeController {
    @Autowired
    private IHouseBigTypeService houseBigTypeService;
    @Autowired
    private IHouseSmallTypeService houseSmallTypeService;
    @Autowired
    private IHouseService houseService;

    /**
     * 查看医生列表数
     * @return
     */
    @GetMapping("/queryCategories")
    public ResponseResult queryCategories() {
        // 查询房屋大类
        List<HouseBigType> houseBigTypes = houseBigTypeService.list();

        // 遍历房屋大类
        for (HouseBigType houseBigType : houseBigTypes) {
            // 根据房屋大类和小类的主外键关系查询小类
            List<HouseSmallType> houseSmallTypes = houseSmallTypeService.list(new QueryWrapper<HouseSmallType>().eq("bigTypeId", houseBigType.getId()));
            // 将房屋小类存到大类集合实体当中
            houseBigType.setSmallTypeList(houseSmallTypes);
            // 遍历房屋小类，根据商品小类和商品的主外键关系查询该小类下的所有房屋
            for (HouseSmallType houseSmallType : houseSmallTypes) {
                List<House> houses = houseService.list(new QueryWrapper<House>().eq("typeId", houseSmallType.getId()));
                // 将所有房屋存到房屋小类实体当中
                houseSmallType.setHouses(houses);
            }
        }
        // 封装数据响应给前端
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", houseBigTypes);
        return ResponseResult.ok(resultMap);
    }
}
