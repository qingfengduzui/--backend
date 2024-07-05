package org.example.test_second.pojo.table;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "favor", description = "是否点赞")
public class favor {
    private Integer id;
    private Integer uid;
}
