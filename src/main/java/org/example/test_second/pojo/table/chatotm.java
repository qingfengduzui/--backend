package org.example.test_second.pojo.table;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(value = "chatotm", description = "发帖")
public class chatotm {
    @ApiModelProperty(value = "发帖编号")
    Integer uid;//发帖编号
    @ApiModelProperty(value = "发帖人编号")
    String id;//发帖人编号
    @ApiModelProperty(value = "发帖信息")
    String message;//发帖信息
    @ApiModelProperty(value = "点赞数")
    Integer favor;//点赞数
    @ApiModelProperty(value = "创建时间")
    @TableField("createTime")
    private LocalDateTime createTime;//创建时间
    @ApiModelProperty(value = "昵称")
    private String nickname;//昵称
    @ApiModelProperty(value = "头像")
    @TableField("fileData")
    private String fileData;//头像
    @ApiModelProperty(value = "回复数")
    private Integer countcomment;//回复数

}
