package org.example.test_second.pojo.table;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Lob;

@Data //生成字段的一系列方法
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@TableName("account") //联系对应数据库的表
@ApiModel(value = "account", description = "账号")
public class account implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 2L;
    @ApiModelProperty(value = "id主键")
    private Integer id;
    @ApiModelProperty(value = "学号")
    private String studentId;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "国家")
    private String country;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "性别")
    private String gender;
    @ApiModelProperty(value = "政治面貌")
    private String political;
    @ApiModelProperty(value = "专业")
    private String education;
    @ApiModelProperty(value = "宿舍号")
    private String dormitory;
    @ApiModelProperty(value = "兴趣爱好")
    private String interests;
    @Lob
    @ApiModelProperty(value = "头像")
    private String fileData;



}
