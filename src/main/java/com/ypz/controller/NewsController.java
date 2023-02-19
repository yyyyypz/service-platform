package com.ypz.controller;

import com.ypz.entity.News;
import com.ypz.entity.ResponseResult;
import com.ypz.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private INewsService newsService;

    @GetMapping("/queryDetail")
    public ResponseResult queryNewsDetail(Integer id) {
        News news = newsService.getById(id);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", news);
        return ResponseResult.ok(resultMap);
    }

}
