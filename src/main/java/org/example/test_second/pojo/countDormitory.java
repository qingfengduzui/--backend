package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "countDormitory", description = "宿舍统计")
public class countDormitory {
    private String dormitory;
    private Integer count;
}
