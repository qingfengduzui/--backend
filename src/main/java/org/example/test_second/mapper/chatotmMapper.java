package org.example.test_second.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.test_second.pojo.table.account;
import org.example.test_second.pojo.table.chatotm;
import org.example.test_second.pojo.table.comments;

import java.util.List;

public interface chatotmMapper extends BaseMapper<chatotm> {

    @Insert("insert into chatotm (message, id, favor) values (#{message}, #{id}, 0)")
    void insertmessage(String message, String id);

    @Select("select * from chatotm")
    List<chatotm> getmessage();


    @Update("UPDATE chatotm SET favor = favor + 1 WHERE uid = #{uid}")
    Integer increasetextfavor(Integer uid);

    @Update("UPDATE chatotm SET favor = favor - 1 WHERE uid = #{uid}")
    Integer decreasetextfavor(Integer uid);

    @Select("select favor from chatotm where uid = #{uid}")
    Integer gettextfavor(Integer uid);

    @Insert("insert into comments (comment, uid, rid, rcid, favor) values (#{comment}, #{uid}, #{rid}, #{rcid}, 0)")
    void insertcommentmessage(String comment, Integer uid, Integer rid, Integer rcid);

    @Select("select * from comments where uid = #{uid}")
    List<comments> gettextmessage(Integer uid);

    @Update("UPDATE comments SET favor = favor + 1 WHERE uid = #{uid} and cid = #{cid}")
    Integer increasecommentfavor(Integer uid, Integer cid);

    @Select("select favor from comments where uid = #{uid} and cid = #{cid}")
    Integer getcommentfavor(Integer uid, Integer cid);

    @Update("UPDATE comments SET favor = favor - 1 WHERE uid = #{uid} and cid = #{cid}")
    Integer decreasecommentfavor(Integer uid, Integer cid);

    @Select("select * from account where id = #{subId}")
    account insertelseinformation(Integer subId);

    @Insert("insert into chatotm (nickname, fileData) values (#{nickname}, #{fileData})")
    void insertelsemessage(String nickname, String fileData);

    @Insert("insert into comments (nickname, fileData) values (#{nickname}, #{fileData})")
    void insertcommentelsemessage(String nickname, String fileData);

    @Update("UPDATE chatotm SET countcomment = countcomment + 1 WHERE uid = #{uid}")
    void commentsaddone(Integer uid);
}
