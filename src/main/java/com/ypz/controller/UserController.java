package com.ypz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.ResponseResult;
import com.ypz.entity.WxUserInfo;
import com.ypz.properties.WeiXinProperties;
import com.ypz.service.IWxUserInfoService;
import com.ypz.utils.HttpClientUtil;
import com.ypz.utils.JwtUtils;
import com.ypz.utils.SystemConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private WeiXinProperties weiXinProperties;

    @Autowired
    private HttpClientUtil httpClientUtil;

    @Autowired
    private IWxUserInfoService wxUserInfoService;

    @RequestMapping("/wxlogin")
    public ResponseResult wxLogin(@RequestBody WxUserInfo wxUserInfo) {
        System.out.println(wxUserInfo.getCode());
        String jscode2sessionUrl = weiXinProperties.getJscode2sessionUrl() + "?appid=" + weiXinProperties.getAppid() + "&secret=" + weiXinProperties.getSecret() + "&js_code=" + wxUserInfo.getCode() + "&grant_type=authorization_code";
        System.out.println(jscode2sessionUrl);
        // 用http请求工具类根据url获取session_key和openid
        String sessionKey_openId = httpClientUtil.sendHttpGet(jscode2sessionUrl);
        // 将字符串解析成json对象
        JSONObject jsonObject = JSON.parseObject(sessionKey_openId);
        // 获取openid
        String openid = null;
        if (jsonObject != null && jsonObject.get("openid") != null) {
            openid = jsonObject.get("openid").toString();
        }
        // 根据openid查询用户
        WxUserInfo userInfo = wxUserInfoService.getOne(new QueryWrapper<WxUserInfo>().eq("openid", openid));
        // 如果用户信息为空则添加用户到数据库，不为空则更新用户信息
        if (userInfo == null) {
            // 封装用户信息
            wxUserInfo.setOpenid(openid); // openid
            wxUserInfo.setRegisterDate(new Date()); // 注册日期
            wxUserInfo.setLastLoginDate(new Date()); // 最近一次登录时间
            // 保存实体到数据库
            wxUserInfoService.save(wxUserInfo);
        } else {
            userInfo.setNickName(wxUserInfo.getNickName()); // 用户名称
            userInfo.setAvatarUrl(wxUserInfo.getAvatarUrl()); //
            userInfo.setLastLoginDate(new Date()); // 最近一次登录时间
            // 更新操作
            wxUserInfoService.updateById(userInfo);
        }
        // jwt生成token响应给前端
        String token = JwtUtils.createJWT(openid, wxUserInfo.getNickName(), SystemConstantUtils.JWT_TTL);
        // 创建map响应给前端
        Map<String, Object> map = new HashMap<>();
        // 封装token到map中
        map.put("token", token);
        return ResponseResult.ok(map);
    }
}
