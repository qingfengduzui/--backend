package org.example.test_second.pojo.table;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("class") //联系对应数据库的表
@ApiModel(value = "class1", description = "班级")
public class class1 {
    private String cid;
    private String cname;
    private Integer studentcount;
}
