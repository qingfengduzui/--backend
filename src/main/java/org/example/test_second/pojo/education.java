package org.example.test_second.pojo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "education", description = "专业统计")
public class education {
    private String education;
    private Integer countnum;
}
