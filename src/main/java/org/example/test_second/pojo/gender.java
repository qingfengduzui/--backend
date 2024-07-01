package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "gender", description = "性别统计")
public class gender {
    private String gender;
    private Integer countnum;
}
