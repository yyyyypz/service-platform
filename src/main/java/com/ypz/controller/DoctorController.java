package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.Doctor;
import com.ypz.entity.DoctorSwiperImage;
import com.ypz.entity.ResponseResult;
import com.ypz.service.IDoctorService;
import com.ypz.service.IDoctorSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查看医生简介
 * @author ypz
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IDoctorSwiperImageService doctorSwiperImageService;

    @GetMapping("/queryDoctorDetail")
    public ResponseResult queryDoctorDetail(Integer id) {
        Doctor doctor = doctorService.getById(id);
        List<DoctorSwiperImage> doctorSwiperImages = doctorSwiperImageService.list(new QueryWrapper<DoctorSwiperImage>().eq("doctorId", doctor.getId()).orderByAsc("sort"));
        doctor.setDoctorSwiperImages(doctorSwiperImages);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", doctor);
        return ResponseResult.ok(resultMap);
    }
}
