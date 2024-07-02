package org.example.test_second.pojo;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@ApiModel(value = "uploadImage", description = "上传图片")
public class uploadImage {
    private MultipartFile file;
    private String studentId;
}
