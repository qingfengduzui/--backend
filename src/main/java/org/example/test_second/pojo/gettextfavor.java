package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "gettextfavor", description = "发帖是否点赞")
public class gettextfavor {
    private Integer id;
}
