package org.example.test_second.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.Span;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;



@Slf4j
@RestController //绑定HTTP响应体和返回，HTTP参数和方法参数
@RequestMapping("nlp") //类中的所有处理方法都将继承这个基础路径
@Api(tags = "自然语言处理")
public class NlpController {

    @GetMapping("/test")
    public void performNlpTask() {
       try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("en-sent.bin");
            SentenceModel model = new SentenceModel(is);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
            String text = "Hello World. This is a test sentence.";
            Span[] spans = sentenceDetector.sentPosDetect(text);
            for (Span span : spans) {
                System.out.println(text.substring(span.getStart(), span.getEnd()));
            }
       } catch (Exception e) {
        e.printStackTrace();
       }
    }

}