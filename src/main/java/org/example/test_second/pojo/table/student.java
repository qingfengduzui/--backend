package org.example.test_second.pojo.table;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("student") //联系对应数据库的表
@ApiModel(value = "student", description = "学生")
public class student {
    private String sid;
    private String sname;
    private String gender;
    private String classid;
}
