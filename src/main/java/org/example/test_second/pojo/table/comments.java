package org.example.test_second.pojo.table;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class comments {
    Integer uid;//帖子id
    Integer cid;//评论id
    Integer rid;//评论人id
    String comment;//评论
    Integer favor;//点赞数
    private LocalDateTime createTime;//创建时间
    Integer rcid;//引用评论id
    
}