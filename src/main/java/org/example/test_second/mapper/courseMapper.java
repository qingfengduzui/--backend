package org.example.test_second.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.test_second.pojo.table.account;
import org.example.test_second.pojo.table.course;
import org.springframework.stereotype.Repository;

@Repository
public interface courseMapper extends BaseMapper<course> {

}
