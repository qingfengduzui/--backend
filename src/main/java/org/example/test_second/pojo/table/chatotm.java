package org.example.test_second.pojo.table;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class chatotm {
    Integer uid;//发帖编号
    String id;//发帖人编号
    String message;//发帖信息
    Integer favor;//点赞数
    private LocalDateTime createTime;//创建时间

}
