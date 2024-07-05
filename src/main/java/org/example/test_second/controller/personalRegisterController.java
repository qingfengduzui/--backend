package org.example.test_second.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.test_second.mapper.accountMapper;
import org.example.test_second.pojo.result;
import org.example.test_second.pojo.table.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController //绑定HTTP响应体和返回，HTTP参数和方法参数
@RequestMapping("personalRegister") //类中的所有处理方法都将继承这个基础路径
@Api(tags = "用户注册流程")
public class personalRegisterController {

    @Autowired
    private accountMapper accountmapper;

    @GetMapping("/registerStatus")
    @ApiOperation("报到注册状态更新")
    public result registerstatus(@RequestParam("studentid") String studentid, @RequestParam("registertatus") Integer registerstatus)
    {
        result res = new result();
        try {
            res.setStatus(true);
            if(registerstatus == 1){
                accountmapper.update1(studentid);
                res.setResult(2);
            } else if (registerstatus == 2) {
                accountmapper.update2(studentid);
                res.setResult(3);
            } else if (registerstatus == 3) {
                accountmapper.update3(studentid);
                res.setResult(4);
            } else if (registerstatus == 4) {
                accountmapper.update4(studentid);
                res.setResult(5);
            } else if(registerstatus == 5){
                accountmapper.update5(studentid);
                res.setResult(6);
            } else {
                res.setStatus(false);
                res.setResult("发生错误");
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @GetMapping("/getRegisterStatus")
    @ApiOperation("获取注册状态")
    public result getregisterstatus(@RequestParam("studentid") String studentid)
    {
        result res = new result();
        try {

            res.setStatus(true);
            res.setResult(accountmapper.getregisterstatus(studentid));
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation("未完成注册邮件通知")
    @GetMapping("/waitEmail")
    public result waitemail(){
        result res = new result();
        try {
            List<account> accounts = accountmapper.findByRegisterStatus();
            accounts.forEach(account -> System.out.println(1));//发送邮件
            res.setStatus(true);
            res.setResult("已发送");
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation("注册完成邮件通知")
    @GetMapping("/endEmail")
    public result endemail(String studentid)
    {
        result res = new result();
        try {
            String email = accountmapper.getemailbystudentid(studentid);
            System.out.println("已完成注册");//发送邮件
            res.setStatus(true);
            res.setResult("已发送");
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

}
