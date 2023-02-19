package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ypz.entity.BigType;
import com.ypz.entity.PageBean;
import com.ypz.entity.ResponseResult;
import com.ypz.entity.SmallType;
import com.ypz.service.IBigTypeService;
import com.ypz.service.ISmallTypeService;
import com.ypz.utils.DateUtil;
import com.ypz.utils.StringUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/bigType")
public class AdminBigTypeController {
    @Autowired
    private IBigTypeService bigTypeService;
    @Autowired
    private ISmallTypeService smallTypeService;
    @Value("${bigTypeImagesFilePath}")
    private String bigTypeImagesFilePath;

    /**
     * 查询所有商品大类
     *
     * @param pageBean
     * @return
     */
    @RequestMapping("/list")
    public ResponseResult list(@RequestBody PageBean pageBean) {
        System.out.println(pageBean);
        String query = pageBean.getQuery().trim();
        Page<BigType> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
        Page<BigType> pageResult = bigTypeService.page(page, new QueryWrapper<BigType>().like(StringUtil.isNotEmpty(query), "name", query));
        Map<String, Object> map = new HashMap<>();
        map.put("bigTypeList", pageResult.getRecords());
        map.put("total", pageResult.getTotal());
        return ResponseResult.ok(map);
    }

    /**
     * 更新图片
     *
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadImage")
    public Map<String, Object> uploadImage(MultipartFile file) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        if (!file.isEmpty()) {
            // 获取文件名
            String originalFilename = file.getOriginalFilename();
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = DateUtil.getCurrentDateStr() + suffixName;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(bigTypeImagesFilePath + newFileName));
            resultMap.put("code", 200);
            resultMap.put("msg", "上传成功");
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("title", newFileName);
            dataMap.put("src", "/image/bigType/" + newFileName);
            resultMap.put("data", dataMap);
        }
        return resultMap;
    }

    /**
     * 根据id获取商品大类图片
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult findById(@PathVariable(value = "id") Integer id) {
        BigType bigType = bigTypeService.getById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("bigType", bigType);
        return ResponseResult.ok(map);
    }

    /**
     * 确认更新大类名名称、描述
     *
     * @param bigType
     * @return
     */
    @RequestMapping("/save")
    public ResponseResult save(@RequestBody BigType bigType) {
        if (bigType.getId() == null || bigType.getId() == -1) {
            bigTypeService.save(bigType);
        } else {
            bigTypeService.saveOrUpdate(bigType);
        }
        return ResponseResult.ok();
    }

    /**
     * 删除商品大类信息
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ResponseResult delete(@PathVariable(value = "id") Integer id) {
        // 加个判断 大类下面如果有小类 返回报错提示
        if (smallTypeService.count(new QueryWrapper<SmallType>().eq("bigTypeId", id)) > 0) {
            return ResponseResult.error(500, "大类下面有小类信息，不能删除");
        } else {
            bigTypeService.removeById(id);
            return ResponseResult.ok();
        }
    }
}
