package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "updatepassword", description = "更新密码")
public class updatepassword {

    private String studentid;
    private Integer verficationcode;
    private String newpassword;
}
