package org.example.test_second.service.impl;

import org.example.test_second.config.MD5PasswordEncoder;
import org.example.test_second.dto.ApiResult;
import org.example.test_second.mapper.accountMapper;
import org.example.test_second.pojo.*;
import org.example.test_second.pojo.table.account;
import org.example.test_second.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Date;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private accountMapper accountmapper;

    @Autowired
    private MD5PasswordEncoder md5PasswordEncoder;

    private Integer verfication;

    @Override
    public result login(LoginInfo loginInfo) {
        String loginaccount = loginInfo.getStudentId();
        String password = loginInfo.getPassword();
        String repassword = md5PasswordEncoder.encode(password);
        result res = new result();
        try{
            account account1 = accountmapper.login(loginaccount, repassword);
            if(account1 == null){
                res.setStatus(false);
                res.setResult("账户或密码错误！");
                return res;
            }
            res.setStatus(true);
            res.setResult(account1);
            return res;
        } catch (DataAccessException e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }
    @Override
    public result logout(LoginInfo loginInfo) {
        result res = new result();
        try{
            Integer i  = accountmapper.logout(loginInfo.getStudentId());
            if(i > 0){
                res.setStatus(true);
                res.setResult("注销成功！");
                return res;
            }
            res.setStatus(false);
            res.setResult("注销失败！");
            return res;
        } catch (Exception e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @Override
    public result register(RegisterInfo registerInfo) {
        Integer verficationcode = registerInfo.getVerficationcode();
        String studentid = registerInfo.getStudentId();
        String name = registerInfo.getName();
        String phone = registerInfo.getPhone();
        String password = registerInfo.getPassword();
        String repassword = md5PasswordEncoder.encode(password);
        result res = new result();
        try {
            if(verficationcode.equals(verfication))
            {
                Integer i = accountmapper.register(studentid,name,phone,repassword);
                if(i == 1)
                {
                    res.setStatus(true);
                    res.setResult("注册成功");
                    return res;
                }
                else{
                    res.setStatus(false);
                    res.setResult("注册失败");
                    return res;
                }
            }
            else{
                res.setStatus(false);
                res.setResult("验证码错误");
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @Override
    public result update(updateAccount updateaccount) {
        result res = new result();
        try{
            String studentid = updateaccount.getStudentID();
            String name = updateaccount.getName();
            String phone = updateaccount.getPhone();
            String nickname = updateaccount.getNickName();
            String country = updateaccount.getCountry();
            String province = updateaccount.getProvince();
            String city = updateaccount.getCity();
            String gender = updateaccount.getGender();
            String political = updateaccount.getPolitical();
            String education = updateaccount.getEducation();
            String dormitory = updateaccount.getDormitory();
            String interests = updateaccount.getInterests();
            String academy = updateaccount.getAcademy();

            Integer i  = accountmapper.update(studentid,name,phone,nickname,country,province,city,gender,political,education,dormitory,interests,academy);
            System.out.println(i);
            if(i > 0){
                res.setStatus(true);
                res.setResult("修改成功！");
                return res;
            }
            res.setStatus(false);
            res.setResult("修改失败！");
            return res;
        } catch (Exception e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @Override
    public result updateheadpicture(headpicture headpicture) {
        result res = new result();
        try{
            byte[] filedata = headpicture.getFileData();
            String studentid = headpicture.getStudentId();
            System.out.println(filedata);
            Integer i = accountmapper.updateheadpicture(filedata, studentid);
            if(i > 0){
                res.setStatus(true);
                res.setResult("修改成功！");
                return res;
            }
            res.setStatus(false);
            res.setResult("修改失败！");
            return res;
        } catch (Exception e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @Override
    public result selectcity(selectsimiliar selectsimiliar) {
        String studentid = selectsimiliar.getStudentid();
        result res = new result();
        try{
            String city = accountmapper.city(studentid);
//            if(city.equals(null))
//            {
//                res.setStatus(false);
//                res.setResult("请先完善个人资料");
//                return res;
//            }
//            else {
                List<account> account1 = accountmapper.selectcity(city);
                if (account1.equals(null)) {
                    res.setStatus(true);
                    res.setResult("不应该为空");
                    return res;
                }
                res.setStatus(true);
                res.setResult(account1);
                return res;
//            }
        } catch (DataAccessException e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }

    }

    @Override
    public result selectinterests(selectsimiliar selectsimiliar) {
        String studentid = selectsimiliar.getStudentid();
        result res = new result();
        try{
            String interests = accountmapper.interests(studentid);
                List<account> account1 = accountmapper.selectinterests(interests);
                if (account1 == null) {
                    res.setStatus(true);
                    res.setResult("不应该为空");
                    return res;
                }
                res.setStatus(true);
                res.setResult(account1);
                return res;
        } catch (DataAccessException e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @Override
    public result selectdormitory(selectsimiliar selectsimiliar) {
        String studentid = selectsimiliar.getStudentid();
        result res = new result();
        try{
            String dormitory = accountmapper.dormitory(studentid);
//            if(dormitory.equals(null))
//            {
//                res.setStatus(false);
//                res.setResult("请先完善个人资料");
//                return res;
//            }
//            else {
                List<account> account1 = accountmapper.selectdormitory(dormitory);
                if (account1.equals(null)) {
                    res.setStatus(true);
                    res.setResult("不应该为空");
                    return res;
                }
                res.setStatus(true);
                res.setResult(account1);
                return res;
//            }
        } catch (DataAccessException e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @Override
    public result sendverfication(verficationCode verficationCode) {
        result res = new result();
        String studentid = verficationCode.getStudentId();
        String name = verficationCode.getName();
        String phone = verficationCode.getPhone();
        try {
            account account1 = accountmapper.ifExitStudent(studentid,name);
            if(account1 == null)
            {
                res.setStatus(false);
                res.setResult("用户不存在");
                return res;
            } else if (account1.getPhone().equals("1")) {
                System.out.println(account1.getPhone());
                res.setStatus(false);
                res.setResult("用户已注册");
                return res;
            } else {
                res.setStatus(true);
                Random random = new Random();
                verfication = random.nextInt(9000) + 1000;
                res.setResult("验证码已发送:"+verfication);
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @Override
    public result updatepassword(updatepassword updatepassword) {
        String studentid = updatepassword.getStudentid();
        String newpassword = updatepassword.getNewpassword();
        String renewpassword = md5PasswordEncoder.encode(newpassword);
        Integer verficationcode = updatepassword.getVerficationcode();
        result res = new result();
        try {
            if(verficationcode.equals(verfication))
            {
                Integer i = accountmapper.updatepassword(studentid,renewpassword);
                if(i == 1)
                {
                    res.setStatus(true);
                    res.setResult("修改成功");
                    return res;
                }
                else{
                    res.setStatus(false);
                    res.setResult("修改失败");
                    return res;
                }
            }
            else{
                res.setStatus(false);
                res.setResult("验证码错误");
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }

    }

    @Override
    public result sendverficationpassword(verficationCode verficationCode) {
        result res = new result();
        String studentid = verficationCode.getStudentId();
        String name = verficationCode.getName();
        String phone = verficationCode.getPhone();
        try {
            account account1 = accountmapper.ifExitStudent(studentid,name);
            if(account1 == null)
            {
                res.setStatus(false);
                res.setResult("用户不存在");
                return res;
            }
            else {
                res.setStatus(true);
                Random random = new Random();
                verfication = random.nextInt(9000) + 1000;
                res.setResult("验证码已发送:" + verfication);
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @Override
    public result getAllByStudentid(Integer id) {
        result res = new result();
        try {
            account account1 = accountmapper.getAllByStudentid(id);
            res.setStatus(true);
            res.setResult(account1);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @Override
    public Integer getuserfavor(Integer id) {
        Integer textfavor = accountmapper.getnumtext(id);
        Integer commentfavor = accountmapper.getnumcomment(id);
        Integer sumfavor = textfavor+commentfavor;
        return sumfavor;
    }
}
