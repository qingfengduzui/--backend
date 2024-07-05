package org.example.test_second.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.test_second.mapper.accountMapper;
import org.example.test_second.pojo.result;
import org.example.test_second.pojo.returnaccountbymajor;
import org.example.test_second.pojo.table.account;
import org.example.test_second.pojo.table.exchangedormitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/web")
@Api(tags = "网页版端口")
public class WebController {

    private String notice;

    @Autowired
    private accountMapper accountmapper;

    @ApiOperation("登录接口")
    @GetMapping("/webLogin")
    public result webLogin(@RequestParam("manager") String manager, @RequestParam("password") String password)
    {
        result res = new result();
        try {
            Integer i = accountmapper.weblogin(manager, password);
            if(i.equals(1)){
                res.setStatus(true);
                res.setResult("登陆成功");
                return res;
            } else {
                res.setStatus(false);
                res.setResult("登陆失败");
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation("获取对应学生信息")
    @GetMapping("/getStuAccount")
    public List<returnaccountbymajor> getStuAccount(@RequestParam("manager") String manager)
    {
        String major = accountmapper.getmajor(manager);
        List<returnaccountbymajor> accountmajor = accountmapper.getstumajor(major);
        return accountmajor;
    }
    @ApiOperation("获取姓名学生信息")
    @GetMapping("/getAccountByName")
    public returnaccountbymajor getAccountbyname(@RequestParam("name") String name)
    {
        return accountmapper.getstudent(name);

    }

    @ApiOperation("获取更换宿舍申请")
    @GetMapping("getApplyforExchangeDormitory")
    public List<exchangedormitory> getApplyforExchangeDormitory(@RequestParam("major") String major)
    {
        List<exchangedormitory> list1 = accountmapper.getApplyforExchangeDormitory(major);
        return list1;
    }

    @ApiOperation("审批更换宿舍申请")
    @GetMapping("/approvalDor")
    public result approvalDor(@RequestParam("ifapprove") Integer ifapprove, @RequestParam("studentid") String studentid)
    {
        result res = new result();
        try {
            if( ifapprove.equals(1))
            {
                System.out.println(1);//发送邮件
                String newdor = accountmapper.getnewdormitory(studentid);
                accountmapper.deletedor(studentid);
                accountmapper.updatedormitory(studentid, newdor);
                res.setStatus(true);
                res.setResult("同意申请");
                return res;
            } else {
                System.out.println(1);//发送邮件
                accountmapper.deletedor(studentid);
                res.setStatus(true);
                res.setResult("拒绝申请");
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation("发布公告")
    @GetMapping("/sannouncement")
    public result sannouncement(@RequestParam("announcement") String announcement)
    {
        result res = new result();
        try {
            this.notice = announcement;
            res.setStatus(true);
            res.setResult("发布成功");
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation("获取公告")
    @GetMapping("/hannouncement")
    public result hannouncement()
    {
        result res = new result();
        res.setStatus(true);
        res.setResult(this.notice);
        return res;
    }




}
