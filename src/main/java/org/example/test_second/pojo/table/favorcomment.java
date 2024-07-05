package org.example.test_second.pojo.table;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "favorcomment", description = "是否点赞")
public class favorcomment {
    private Integer id;
    private Integer uid;
    private Integer cid;
}
