package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.WxUserInfo;
import com.ypz.mapper.WxUserInfoMapper;
import com.ypz.service.IWxUserInfoService;
import org.springframework.stereotype.Service;

@Service
public class IWxUserInfoServiceImpl extends ServiceImpl<WxUserInfoMapper, WxUserInfo> implements IWxUserInfoService {
}
