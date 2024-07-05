package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "textFavor", description = "发帖点赞")
public class textFavor {
    private Integer id;
    @ApiModelProperty(value = "是否为点赞")
    private boolean ifFavor;
    @ApiModelProperty(value = "发帖编号")
    private Integer uid;
}
