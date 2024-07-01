package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "verficationcode", description = "获取验证码")
public class verficationCode {
    private String studentId;
    private String name;
    private String phone;
}
