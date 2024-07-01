package org.example.test_second.pojo.table;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "chat", description = "单点消息")
public class Chat {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer targetUserId;
    private LocalDateTime createTime;
    private String content;

}
