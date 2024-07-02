package org.example.test_second.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.test_second.pojo.*;
import org.example.test_second.pojo.table.account;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface accountMapper extends BaseMapper<account> {

    @Select("select * from account where studentId=#{loginaccount} and password=#{password}")
    account login(String loginaccount, String password);

    @Select("select * from account where studentId=#{loginaccount}")
    account loginif(String loginaccount);

    @Delete("delete from account where studentId=#{loginaccount}")
    Integer logout(String loginaccount);

    @Update("update account set fileData = #{filedata} where studentId = #{studentid}")
    Integer updateheadpicture(byte[] filedata, String studentid);

    @Update("update account set name = #{name}, phone = #{phone}, nickName = #{nickname}, country = #{country}, province = #{province}, city = #{city}, gender = #{gender}, political = #{political}, education = #{education}, dormitory = #{dormitory}, interests = #{interests}  where studentId = #{studentid}")
    Integer update(String studentid, String name, String phone, String nickname, String country, String province, String city, String gender, String political, String education, String dormitory, String interests);

    @Select("select city from account where studentId = #{studentid}")
    String city(String studentid);

    @Select("select * from account where city = #{city}")
    List<account> selectcity(String city);

    @Select("select interests from account where studentId = #{studentid}")
    String interests(String studentid);

    @Select("select * from account where interests = #{interests}")
    List<account> selectinterests(String interests);

    @Select("select dormitory from account where studentId = #{studentid}")
    String dormitory(String studentid);

    @Select("select * from account where dormitory = #{dormitory}")
    List<account> selectdormitory(String dormitory);

    @Select("select * from account where studentId = #{studentid} and name = #{name}")
    account ifExitStudent(String studentid, String name);

    @Update("update account set phone = #{phone}, password = #{password} where studentId = #{studentid} and name = #{name}")
    Integer register(String studentid, String name, String phone, String password);

    @Select("SELECT province, COUNT(*) AS countnum FROM account GROUP BY province;")
    List<province> getprovincestudent();

    @Select("SELECT gender, COUNT(*) AS countnum FROM account GROUP BY gender;")
    List<gender> getgenderstudent();

    @Select("SELECT education, COUNT(*) AS countnum FROM account GROUP BY education;")
    List<education> geteducationstudent();

    @Select("SELECT interests, COUNT(*) AS countnum FROM account GROUP BY interests;")
    List<interests> getinterestsstudent();

    @Select("SELECT political, COUNT(*) AS countnum FROM account GROUP BY political;")
    List<political> getpoliticalstudent();

    @Update("update account set password = #{renewpassword} where studentId = #{studentid}")
    Integer updatepassword(String studentid, String renewpassword);

    @Select("select count(*) from account where phone != '-1'")
    Integer countregisterstudent();


    @Update("update account set fileData = #{imagePath} where studentId = #{studentId}")
    Integer storageimage(String imagePath, String studentId);

    @Select("select fileData from account where studentId = #{studentId}")
    String getImage(String studentId);

    @Select("select education from account where studentId = #{studentid};")
    String geteducationbystudentid(String studentid);
}

