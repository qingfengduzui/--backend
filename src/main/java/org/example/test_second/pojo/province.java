package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "province", description = "省份统计")
public class province {
    private String province;
    private Integer countnum;
}
