package com.ypz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ypz.entity.ProductSwiperImage;
import com.ypz.mapper.ProductSwiperImageMapper;
import com.ypz.service.IProductSwiperImageService;
import org.springframework.stereotype.Service;

@Service
public class IProductSwiperImageImpl extends ServiceImpl<ProductSwiperImageMapper, ProductSwiperImage> implements IProductSwiperImageService {
}
