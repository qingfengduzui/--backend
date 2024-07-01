package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "selectsimiliar", description = "查找相同信息")
public class selectsimiliar {
    private String studentid;
}
