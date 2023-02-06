package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.Admin;
import com.ypz.entity.ResponseResult;
import com.ypz.service.IAdminService;
import com.ypz.utils.JwtUtils;
import com.ypz.utils.StringUtil;
import com.ypz.utils.SystemConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAdminService adminService;

    @PostMapping("/adminLogin")
    public ResponseResult login(@RequestBody Admin admin) {
        // 判空
        if (admin == null) {
            return ResponseResult.error("用户名或密码为空！");
        }
        // 用户名判空
        if (StringUtil.isEmpty(admin.getUserName())) {
            return ResponseResult.error("用户名为空！");
        }
        // 密码判空
        if (StringUtils.isEmpty(admin.getPassword())) {
            return ResponseResult.error("密码为空");
        }
        // 根据用户名查询用户
        Admin queryAdmin = adminService.getOne(new QueryWrapper<Admin>().eq("userName", admin.getUserName()));
        // 根据用户名未查询到用户
        if (StringUtils.isEmpty(queryAdmin)) {
            return ResponseResult.error("该用户不存在！");
        }
        // 判断密码是否正确
        if (!queryAdmin.getPassword().equals(admin.getPassword())) {
            return ResponseResult.error("密码错误！");
        }
        // 用户名和密码未则生成token给前端
        String token = JwtUtils.createJWT("-1", "admin", SystemConstantUtils.JWT_TTL);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("token", token);
        return ResponseResult.ok(resultMap);
    }
}
