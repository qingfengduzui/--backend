package org.example.test_second.pojo.table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(value = "comments", description = "发帖评论")
public class comments {
    @ApiModelProperty(value = "帖子id")
    Integer uid;//帖子id
    @ApiModelProperty(value = "评论id")
    Integer cid;//评论id
    @ApiModelProperty(value = "评论人id")
    Integer rid;//评论人id
    @ApiModelProperty(value = "评论")
    String comment;//评论
    @ApiModelProperty(value = "点赞数")
    Integer favor;//点赞数
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;//创建时间
    @ApiModelProperty(value = "引用评论id")
    Integer rcid;//引用评论id
    @ApiModelProperty(value = "昵称")
    private String nickname;//昵称
    @ApiModelProperty(value = "头像")
    private String fileData;//头像
    
}