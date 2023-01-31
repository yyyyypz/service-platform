package com.ypz.controller;

import com.ypz.service.ISmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smallType")
public class SmallTypeController {
    @Autowired
    private ISmallTypeService smallTypeService;

}
