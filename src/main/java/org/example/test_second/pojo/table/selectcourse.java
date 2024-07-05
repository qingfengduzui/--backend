package org.example.test_second.pojo.table;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("selectcourse") //联系对应数据库的表
@ApiModel(value = "selectcourse", description = "选课")
public class selectcourse {
    private String sid;
    private String coid;
    private Integer grade;
}
