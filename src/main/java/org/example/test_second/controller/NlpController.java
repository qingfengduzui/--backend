package org.example.test_second.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.Span;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController //绑定HTTP响应体和返回，HTTP参数和方法参数
@RequestMapping("nlp") //类中的所有处理方法都将继承这个基础路径
@Api(tags = "自然语言处理")
public class NlpController {

    @GetMapping("/test")
    public ResponseEntity<?> performNlpTask(@RequestParam(name = "text", required = false, defaultValue = "Hello World. This is a test sentence.") String text) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("en-sent.bin")) {
            SentenceModel model = new SentenceModel(is);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
            Span[] spans = sentenceDetector.sentPosDetect(text);
            List<String> sentences = new ArrayList<>();
            for (Span span : spans) {
                sentences.add(text.substring(span.getStart(), span.getEnd()));
            }
            return ResponseEntity.ok(sentences);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the text");
        }
    }

}