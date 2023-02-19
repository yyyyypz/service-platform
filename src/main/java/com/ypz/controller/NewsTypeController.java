package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.News;
import com.ypz.entity.NewsType;
import com.ypz.entity.ResponseResult;
import com.ypz.service.INewsService;
import com.ypz.service.INewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsTypeController {
    @Autowired
    private INewsService newsService;
    @Autowired
    private INewsTypeService newsTypeService;

    @GetMapping("/queryAll")
    public ResponseResult queryAll() {
        List<NewsType> newsTypes = newsTypeService.list();
        for (NewsType newsType : newsTypes) {
            List<News> news = newsService.list(new QueryWrapper<News>().eq("typeId", newsType.getId()));
            newsType.setNews(news);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", newsTypes);
        return ResponseResult.ok(resultMap
        );
    }
}
