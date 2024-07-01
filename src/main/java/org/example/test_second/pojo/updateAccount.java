package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "updateAccount", description = "更新账户")
public class updateAccount {
    private String studentID;

    private String name;

    private String phone;

    private String nickName;

    private String country;

    private String province;

    private String city;

    private String gender;

    private String political;

    private String education;

    private String dormitory;

    private String interests;

    private Date birthday;

}
