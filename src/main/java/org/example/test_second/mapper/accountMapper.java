package org.example.test_second.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.test_second.pojo.*;
import org.example.test_second.pojo.table.account;
import org.example.test_second.pojo.table.exchangedormitory;
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

    @Update("update account set name = #{name}, phone = #{phone}, nickName = #{nickname}, country = #{country}, province = #{province}, city = #{city}, gender = #{gender}, political = #{political}, education = #{education}, dormitory = #{dormitory}, interests = #{interests}, academy = #{academy}  where studentId = #{studentid}")
    Integer update(String studentid, String name, String phone, String nickname, String country, String province, String city, String gender, String political, String education, String dormitory, String interests, String academy);

    @Select("select province from account where studentId = #{studentid}")
    String city(String studentid);

    @Select("select * from account where province = #{city}")
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

    @Select("SELECT COUNT(*) FROM account WHERE LENGTH(password) = 32")
    Integer countregisterstudent();


    @Update("update account set fileData = #{imagePath} where studentId = #{studentId}")
    Integer storageimage(String imagePath, String studentId);

    @Select("select fileData from account where studentId = #{studentId}")
    String getImage(String studentId);

    @Select("select education from account where studentId = #{studentid};")
    String geteducationbystudentid(String studentid);

    @Select("select fileData from account where id = #{id}")
    String getImagebyId(Integer id);

    @Select("select * from account where id = #{id}")
    account getAllByStudentid(Integer id);

    @Select("SELECT COUNT(*) \n" +
            "FROM favor \n" +
            "INNER JOIN chatotm ON favor.uid = chatotm.uid \n" +
            "WHERE chatotm.id = #{id};")
    Integer getnumtext(Integer id);

    @Select("SELECT COUNT(*) \n" +
            "FROM favorcomment \n" +
            "INNER JOIN comments ON favorcomment.uid = comments.uid and favorcomment.cid = comments.cid \n" +
            "WHERE comments.rid = #{id};")
    Integer getnumcomment(Integer id);

    @Update("update account set registerStatus = 2 where studentID = #{studentid}")
    void update1(String studentid);

    @Update("update account set registerStatus = 3 where studentID = #{studentid}")
    void update2(String studentid);

    @Update("update account set registerStatus = 4 where studentID = #{studentid}")
    void update3(String studentid);

    @Update("update account set registerStatus = 5 where studentID = #{studentid}")
    void update4(String studentid);

    @Select("select * from account where registerStatus != 6")
    List<account> findByRegisterStatus();

    @Select("select email from account where studentID = #{studentid}")
    String getemailbystudentid(String studentid);

    @Update("update account set background = #{imagePath} where studentId = #{studentId}")
    Integer storagebackground(String imagePath, String studentId);

    @Select("select background from account where  id = #{id}")
    String getbackground(Integer id);

    @Update("update account set jingxuanpic = #{imagePath} where studentId = #{studentId}")
    Integer storagejingxuanpic(String imagePath, String studentId);

    @Select("select jingxuanpic from account where  id = #{id}")
    String getjingxuanpic(Integer id);

    @Update("update account set qqsign = #{qqsign} where id = #{id}")
    Integer upqqsign(Integer id, String qqsign);

    @Select("select qqsign from account where id = #{id}")
    String getqqsign(Integer id);

    @Select("select count(*) from webiogin where manager = #{manager} and password = #{password}")
    Integer weblogin(String manager, String password);

    @Select("select major from webiogin where manager = #{manager}")
    String getmajor(String manager);

    @Select("select studentID, name, phone, province, education, dormitory, email, registerStatus from account where academy = #{major}")
    List<returnaccountbymajor> getstumajor(String major);

    @Update("update account set registerStatus = 6 where studentID = #{studentid}")
    void update5(String studentid);

    @Select("select registerStatus from account where studentID = #{studentid}")
    Integer getregisterstatus(String studentid);

    @Select("select studentID, name, phone, province, education, dormitory, email from account where name = #{name}")
    returnaccountbymajor getstudent(String name);

    @Select("SELECT dormitory, COUNT(*) AS count\n" +
            "FROM account\n" +
            "GROUP BY dormitory\n" +
            "ORDER BY count DESC;")
    List<countDormitory> getcountdormitory();

    @Insert("insert into exchangedormitory (studentid,name,olddormitory,newdormitory,major,reason) values (#{studentid},#{name},#{olddormitory},#{newdormitory},#{major},#{reason})")
    void insertintoexchangedormitory(String studentid, String name, String olddormitory, String newdormitory, String major, String reason);

    @Select("select * from exchangedormitory where major = #{major}")
    List<exchangedormitory> getApplyforExchangeDormitory(String major);

    @Select("select newdormitory from exchangedormitory where studentid = #{studentid}")
    String getnewdormitory(String studentid);

    @Delete("delete from exchangedormitory where studentid = #{studentid}")
    void deletedor(String studentid);

    @Update("update account set dormitory = #{newDor} where studentid = #{studentid}")
    void updatedormitory(String studentid,String newDor);
}

