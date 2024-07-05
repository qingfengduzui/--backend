package org.example.test_second.pojo.table;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("course") //联系对应数据库的表
@ApiModel(value = "course", description = "课程")
public class course {
    private String coid;
    private String coname;
    private Integer codegree;
    private String cohao;
}
