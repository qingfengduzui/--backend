package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "getcommentfavor", description = "发帖评论是否点赞")
public class getcommentfavor {
    private Integer id;
    private Integer uid;
}