package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "result", description = "后端返回结果")
public class result {
    private Boolean status;
    private Object result;
}

//@Data
//@ApiModel(value = "result", description = "后端返回结果")
//public class result<T> {
//    private Boolean status;
//    private T result;
//}
