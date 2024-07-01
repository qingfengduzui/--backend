package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "headpicture", description = "头像")
public class headpicture {
    private String studentId; //学号
    private byte[] fileData; //头像二进制
}
