package org.example.test_second.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.example.test_second.pojo.result;
import org.example.test_second.service.impl.AuthServiceImpl;
import org.example.test_second.service.impl.WeatherService;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Document;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    @GetMapping("/analyze1")
    public ResponseEntity<?> analyzeTextFromUrl1(@RequestParam String urlString) {
        Map<String, Long> result = new HashMap<>();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            String text;
            try (Scanner scanner = new Scanner(conn.getInputStream())) {
                text = scanner.useDelimiter("\\A").next();
            }
            org.jsoup.nodes.Document doc = Jsoup.parse(text);
            String bodyText = doc.body().text();
            result = Pattern.compile("\\s+")
                    .splitAsStream(bodyText)
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error processing the URL");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/analyze")
    public ResponseEntity<?> analyzeTextFromUrl(@RequestParam String urlString) {
        Map<String, Long> result = new HashMap<>();
        try {
            // 设置Edge
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless"); // 无界面模式
            System.setProperty("webdriver.edge.driver", "C:\\Users\\王旭博\\Desktop\\test_one\\Driver_Notes\\msedgedriver.exe"); // 设置EdgeDriver路径
            WebDriver driver = new EdgeDriver(options);

            // 使用Selenium获取动态页面内容
            driver.get(urlString);
            int seconds = 10;

// 将这个整数值转换为Duration对象
            java.time.Duration duration = java.time.Duration.ofSeconds(seconds);
            // 显式等待，确保页面已加载完成
            WebDriverWait wait = new WebDriverWait(driver,duration);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

            String bodyText = driver.findElement(By.tagName("body")).getText();

            // 关闭WebDriver
            driver.quit();

            // 分析文本
            result = Pattern.compile("\\s+")
                    .splitAsStream(bodyText)
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error processing the URL");
        }

        return ResponseEntity.ok(result);
    }
}
