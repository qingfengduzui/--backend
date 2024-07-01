package org.example.test_second.pojo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "interests", description = "爱好统计")
public class interests {
    private String interests;
    private Integer countnum;
}
