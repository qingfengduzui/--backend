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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<province> provinceList = countInformationService.provincestudent();
        for(province item : provinceList)
        {
            if(item.getProvince() == null || item.getProvince().isEmpty())
            {
                item.setProvince("未注册");
            } else if(item.getProvince().equals("内蒙古自治区")){
                String shortProvinceName = item.getProvince().substring(0, 3);
                item.setProvince(shortProvinceName);
        }
            else {
                String shortProvinceName = item.getProvince().substring(0, 2);
                item.setProvince(shortProvinceName);
            }
        }
        return provinceList;
    }



    @ApiOperation(value = "获取各性别的学生人数")
    @GetMapping("/genderStudent")
    public List<gender> genderstudent()
    {
        List<gender> genderList = countInformationService.genderstudent();
        for(gender item : genderList)
        {
            if(item.getGender() == null || item.getGender().isEmpty())
            {
                item.setGender("未注册");
            }
        }
        return genderList;
    }

    @ApiOperation(value = "获取各专业的学生人数")
    @GetMapping("/educationStudent")
    public List<education> educationstudent()
    {
        List<education> educationList = countInformationService.educationstudent();
        for(education item : educationList)
            if(item.getEducation() == null || item.getEducation().isEmpty())
            {
                item.setEducation("未注册");
            }
        return educationList;
    }

    @ApiOperation(value = "获取各兴趣爱好的学生人数")
    @GetMapping("/interestsStudent")
    public List<interests> interestsstudent()
    {
        List<interests> interestsList = countInformationService.interestsstudent();
    for (interests item : interestsList) {
        if (item.getInterests() == null || item.getInterests().isEmpty()) {
            item.setInterests("未注册");
        }
    }
    return interestsList;
    }

    @ApiOperation(value = "获取各政治面貌的学生人数")
    @GetMapping("/politicalStudent")
    public List<political> politicalstudent()
    {
        List<political> politicalList = countInformationService.politicalstudent();
        for(political item : politicalList)
        {
            if(item.getPolitical() == null || item.getPolitical().isEmpty()) {
                item.setPolitical("未注册");
            }
        }
        return politicalList;
    }

    @ApiOperation(value = "获取已完成注册人数")
    @GetMapping("/countRegisterStudent")
    public result countregisterstudent()
    {
        result res = new result();
        res.setStatus(true);
        Integer i = countInformationService.countregisterstudent();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("描述", "已完成注册人数");
        resultMap.put("count", i);
        res.setResult(resultMap);
        return res;
    }


}
