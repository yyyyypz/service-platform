package com.ypz.controller;

import com.ypz.entity.PageBean;
import com.ypz.entity.ResponseResult;
import com.ypz.entity.SmallType;
import com.ypz.service.IBigTypeService;
import com.ypz.service.ISmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/smallType")
public class AdminSmallTypeController {
    @Autowired
    private ISmallTypeService smallTypeService;

    @Autowired
    private IBigTypeService bigTypeService;

    @RequestMapping("/list")
    public ResponseResult list(@RequestBody PageBean pageBean) {
        System.out.println(pageBean);
        Map<String, Object> map = new HashMap<>();
        map.put("name", pageBean.getQuery().trim());
        map.put("start", pageBean.getStart());
        map.put("pageSize", pageBean.getPageSize());
        List<SmallType> smallTypeList = smallTypeService.list(map);
        Long total = smallTypeService.getTotal(map);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("smallTypeList", smallTypeList);
        resultMap.put("total", total);
        return ResponseResult.ok(resultMap);
    }
}
