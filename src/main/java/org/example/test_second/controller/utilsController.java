package org.example.test_second.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.example.test_second.pojo.result;
import org.example.test_second.service.impl.AuthServiceImpl;
import org.example.test_second.service.impl.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/utils")
@Api(tags = "工具类接口")
public class utilsController {
    public final WeatherService weatherService;

    @Autowired //将依赖关系自动注入到类中
    public utilsController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<?> weather()
    {
        return weatherService.getWeatherInfo();
    }
}
