package com.ypz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ypz.entity.Doctor;
import com.ypz.entity.Hospital;
import com.ypz.entity.MedicalType;
import com.ypz.entity.ResponseResult;
import com.ypz.service.IDoctorService;
import com.ypz.service.IHospitalService;
import com.ypz.service.IMedicalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询可预约医生列表数据
 * @author ypz
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private IHospitalService hospitalService;
    @Autowired
    private IMedicalTypeService medicalTypeService;
    @Autowired
    private IDoctorService doctorService;

    @GetMapping("/queryBook")
    public ResponseResult queryBook() {
        // 查询医院
        List<Hospital> hospitals = hospitalService.list();
        // 遍历医院
        for (Hospital hospital : hospitals) {
            // 根据主外键关系获取科目
            List<MedicalType> medicalTypes = medicalTypeService.list(new QueryWrapper<MedicalType>().eq("hospitalId", hospital.getId()));
            hospital.setMedicalTypeList(medicalTypes);
            for (MedicalType medicalType : medicalTypes) {
                List<Doctor> doctors = doctorService.list(new QueryWrapper<Doctor>().eq("typeId", medicalType.getId()));
                medicalType.setDoctors(doctors);
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", hospitals);
        return ResponseResult.ok(resultMap);
    }
}
