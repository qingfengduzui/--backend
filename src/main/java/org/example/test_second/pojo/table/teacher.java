package org.example.test_second.pojo.table;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("teacher") //联系对应数据库的表
@ApiModel(value = "teacher", description = "老师")
public class teacher {
    private String tid;
    private String tname;
    private String tfunction;
}
