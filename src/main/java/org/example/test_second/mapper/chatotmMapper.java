package org.example.test_second.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.test_second.pojo.table.*;

import java.util.List;

public interface chatotmMapper extends BaseMapper<chatotm> {

    @Insert("insert into chatotm (message, id) values (#{message}, #{id})")
    void insertmessage(String message, String id);

    @Select("select * from chatotm")
    List<chatotm> getmessage();


    @Update("UPDATE chatotm SET favor = favor + 1 WHERE uid = #{uid}")
    Integer increasetextfavor(Integer uid);

    @Update("UPDATE chatotm SET favor = favor - 1 WHERE uid = #{uid}")
    Integer decreasetextfavor(Integer uid);

    @Select("select favor from chatotm where uid = #{uid}")
    Integer gettextfavor(Integer uid);

    @Insert("insert into comments (comment, uid, rid, rcid,favor) values (#{comment}, #{uid}, #{rid}, #{rcid},#{favor})")
    void insertcommentmessage(String comment, Integer uid, Integer rid, Integer rcid,Integer favor);

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

    @Insert("update chatotm set nickname = #{nickname}, fileData = #{fileData} where id = #{id}")
    void insertelsemessage(String nickname, String fileData,String id);

    @Update("update comments set nickname = #{nickname}, fileData = #{fileData} where rid = #{rid}")
    void insertcommentelsemessage(String nickname, String fileData, Integer rid);

    @Update("UPDATE chatotm SET countcomment = countcomment + 1 WHERE uid = #{uid}")
    void commentsaddone(Integer uid);

    @Select("SELECT * FROM chatotm ORDER BY favor DESC LIMIT 6")
    List<chatotm> hotmessage();


    @Insert("insert into favor (id, uid) values (#{id}, #{uid})")
    void addfavor(Integer id, Integer uid);

    @Delete("delete from favor where id = #{id} and uid = #{uid}")
    void deletefavor(Integer id, Integer uid);

    @Select("select * from favor where id = #{id}")
    List<favor> gettextfavorbyid(Integer id);

    @Insert("insert into favorcomment (id, uid,cid) values (#{id}, #{uid}, #{cid})")
    void addcommentfavor(Integer id, Integer uid, Integer cid);

    @Delete("delete from favorcomment where id = #{id} and uid = #{uid} and cid = #{cid}")
    void deletecommentfavor(Integer id, Integer uid, Integer cid);

    @Select("select * from favorcomment where id = #{id} and uid = #{uid}")
    List<favorcomment> getcommentfavorbyiduid(Integer id, Integer uid);

}
