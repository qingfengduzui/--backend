package org.example.test_second.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.test_second.pojo.*;
import org.example.test_second.pojo.table.account;
import org.example.test_second.service.impl.AuthServiceImpl;
import org.example.test_second.service.impl.CountInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/count")
@Api(tags = "学生信息统计")
public class CountInformationController {

    public final CountInformationServiceImpl countInformationService;

    @Autowired
    public CountInformationController(CountInformationServiceImpl countInformationService) {
        this.countInformationService = countInformationService;
    }

    @ApiOperation(value = "获取各省的学生人数")
    @GetMapping("/provinceStudent")
    public List<province> provincestudent()
    {
        return countInformationService.provincestudent();
    }

    @ApiOperation(value = "获取各性别的学生人数")
    @GetMapping("/genderStudent")
    public List<gender> genderstudent()
    {
        return countInformationService.genderstudent();
    }

    @ApiOperation(value = "获取各专业的学生人数")
    @GetMapping("/educationStudent")
    public List<education> educationstudent()
    {
        return countInformationService.educationstudent();
    }

    @ApiOperation(value = "获取各兴趣爱好的学生人数")
    @GetMapping("/interestsStudent")
    public List<interests> interestsstudent()
    {
        return countInformationService.interestsstudent();
    }

    @ApiOperation(value = "获取各政治面貌的学生人数")
    @GetMapping("/politicalStudent")
    public List<political> politicalstudent()
    {
        return countInformationService.politicalstudent();
    }

    @ApiOperation(value = "获取已完成注册人数")
    @GetMapping("/countRegisterStudent")
    public Integer countregisterstudent()
    {
        return countInformationService.countregisterstudent();
    }


}
