package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "logininfo", description = "登录")
public class LoginInfo {
    private String studentId; //学号
    private String password; //密码
}
