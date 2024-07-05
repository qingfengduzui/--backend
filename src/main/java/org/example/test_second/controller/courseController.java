//package org.example.test_second.controller;
//
//
//import io.swagger.annotations.Api;
//import lombok.extern.slf4j.Slf4j;
//import org.example.test_second.service.impl.AuthServiceImpl;
//import org.example.test_second.service.impl.CourseServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController //绑定HTTP响应体和返回，HTTP参数和方法参数
//@RequestMapping("course") //类中的所有处理方法都将继承这个基础路径
//@Api(tags = "课程接口")
//public class courseController {
//    public final CourseServiceImpl courseService;
//
//    @Autowired //将依赖关系自动注入到类中
//    public CourseController(CourseServiceImpl courseService) {
//        this.courseService = courseService;
//    }
//
//
//}
