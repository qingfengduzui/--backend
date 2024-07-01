package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "political", description = "政治面貌统计")
public class political {
    private String political;
    private Integer countnum;
}
