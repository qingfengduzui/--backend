package org.example.test_second.pojo.table;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "exchangedormitory", description = "更换宿舍信息记录")
public class exchangedormitory {
    private String studentid;
    private String name;
    private String olddormitory;
    private String newdormitory;
    private String major;
    private String reason;
}
