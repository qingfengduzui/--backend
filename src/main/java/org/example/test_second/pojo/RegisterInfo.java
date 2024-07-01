package org.example.test_second.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) //属性比较时，父类与子类一同比较
@Data
@ApiModel(value = "registerinfo", description = "注册")
public class RegisterInfo extends LoginInfo {
    private String name;
    private String phone;
    private Integer verficationcode;

}
