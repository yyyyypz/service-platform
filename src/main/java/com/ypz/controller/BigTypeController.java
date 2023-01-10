package com.ypz.controller;

import com.ypz.entity.BigType;
import com.ypz.entity.ResponseResult;
import com.ypz.service.IBigTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bigType")
public class BigTypeController {
    @Autowired
    private IBigTypeService iBigTypeService;

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
}
