package org.example.test_second.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.test_second.mapper.accountMapper;
import org.example.test_second.pojo.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
@RestController //绑定HTTP响应体和返回，HTTP参数和方法参数
@RequestMapping("major") //类中的所有处理方法都将继承这个基础路径
@Api(tags = "培养方案")
public class JsonFileController {

    @Autowired
    private accountMapper accountmapper;

    @GetMapping(value = "/getCourseByName", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "返回主修专业对应培养方案")
    public result getJsonFileByName(@RequestParam String studentid) throws IOException {
        String programName = accountmapper.geteducationbystudentid(studentid);
        result res = new result();

        // ObjectMapper实例用于解析JSON
        ObjectMapper objectMapper = new ObjectMapper();

        File folder = new File("C:\\Users\\王旭博\\Desktop\\test_one\\test_second\\src\\main\\java\\org\\example\\test_second\\courseJson");
        File[] listOfFiles = folder.listFiles();
        // 遍历所有文件
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                // 解析JSON文件内容
                JsonNode jsonNode = objectMapper.readTree(content);

                // 检查"programName"字段是否与传入参数匹配
                if (jsonNode.has("programBaseInfo") && jsonNode.get("programBaseInfo").has("majorName") && jsonNode.get("programBaseInfo").get("majorName").asText().equals(programName)) {
                    res.setStatus(true);
                    res.setResult(content);
                    return res; // 返回匹配的JSON文件内容
                }
            }
        }

        // 如果没有找到匹配的文件，返回错误信息或空内容
        res.setResult("");
        res.setStatus(false);
        return res;
    }
}