package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "commentfavor", description = "评论点赞")
public class commentfavor extends textFavor{
    private Integer cid;
}
