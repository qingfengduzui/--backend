package org.example.test_second.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.test_second.mapper.accountMapper;
import org.example.test_second.mapper.chatotmMapper;
import org.example.test_second.pojo.commentfavor;
import org.example.test_second.pojo.result;
import org.example.test_second.pojo.table.Chat;
import org.example.test_second.pojo.table.account;
import org.example.test_second.pojo.table.chatotm;
import org.example.test_second.pojo.table.comments;
import org.example.test_second.pojo.textFavor;
import org.example.test_second.service.impl.AuthServiceImpl;
import org.example.test_second.service.impl.ChatServiceImpl;
import org.example.test_second.utils.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.test_second.pojo.ResultTest;

import java.util.List;

@Slf4j
@RestController //绑定HTTP响应体和返回，HTTP参数和方法参数
@RequestMapping("chat") //类中的所有处理方法都将继承这个基础路径
@Api(tags = "聊天接口")
public class ChatController {

    public final ChatServiceImpl chatService;
    @Autowired
    private WebSocket webSocket;

    @Autowired
    private chatotmMapper chatotmmapper;

    @Autowired
    public ChatController(ChatServiceImpl chatService) {
        this.chatService = chatService;
    }


    @ApiOperation(value = "单点消息")
    @PostMapping("send")
    public ResultTest sendMessage(@RequestBody Chat chat){
        webSocket.sendOneMessage(chat.getTargetUserId(), chat.getContent());
        return ResultTest.success();
    }
    @ApiOperation(value = "发送全局发帖消息")
    @PostMapping("sendtextall")
    //信息和用户ID
    public ResultTest testMessage(@RequestParam(name = "message", required = false, defaultValue = "World") String message, String id){
        //数据插入表
        chatotmmapper.insertmessage(message, id);
        Integer subId = Integer.parseInt(id);
        account elseinformation = chatotmmapper.insertelseinformation(subId);
        String nickname = elseinformation.getNickName();
        String fileData = elseinformation.getFileData();
        chatotmmapper.insertelsemessage(nickname,fileData);
        //发送实时单条信息
        webSocket.sendAllMessage(message, id);
        return ResultTest.success();
    }

    @ApiOperation(value = "发帖点赞功能")
    @PostMapping("/textfavor")
    public result textfavor(@RequestBody textFavor textfavor)
    {
        Integer uid = textfavor.getUid();
        boolean iffavor = textfavor.isIfFavor();
        result res = new result();
        try {
            if(iffavor){
                Integer i = chatotmmapper.increasetextfavor(uid);
                Integer countfavor = chatotmmapper.gettextfavor(uid);
                res.setStatus(true);
                res.setResult(countfavor);
                return res;
            } else {
                Integer i = chatotmmapper.decreasetextfavor(uid);
                Integer countfavor = chatotmmapper.gettextfavor(uid);
                res.setStatus(true);
                res.setResult(countfavor);
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }


    @ApiOperation(value = "发送全局回复消息")
    @PostMapping("sendcommentall")
    public ResultTest commentMessage(@RequestParam(name = "comment", required = false, defaultValue = "World") String comment, Integer uid, Integer rid, Integer rcid){
        //数据插入表
        chatotmmapper.insertcommentmessage(comment,uid,rid,rcid);
        Integer subId = rid;
        account elseinformation = chatotmmapper.insertelseinformation(subId);
        String nickname = elseinformation.getNickName();
        String fileData = elseinformation.getFileData();
        chatotmmapper.insertcommentelsemessage(nickname,fileData);
        //发送实时单条信息
        webSocket.sendAllMessage(comment, uid, rid, rcid);
        chatotmmapper.commentsaddone(uid);
        return ResultTest.success();
    }

    @ApiOperation(value = "评论点赞功能")
    @PostMapping("/commentfavor")
    public result commentfavor(@RequestBody commentfavor commentfavor)
    {
        Integer uid = commentfavor.getUid();
        boolean iffavor = commentfavor.isIfFavor();
        Integer cid = commentfavor.getCid();
        result res = new result();
        try {
            if(iffavor){
                Integer i = chatotmmapper.increasecommentfavor(uid,cid);
                Integer countfavor = chatotmmapper.getcommentfavor(uid,cid);
                res.setStatus(true);
                res.setResult(countfavor);
                return res;
            } else {
                Integer i = chatotmmapper.decreasecommentfavor(uid,cid);
                Integer countfavor = chatotmmapper.getcommentfavor(uid,cid);
                res.setStatus(true);
                res.setResult(countfavor);
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("异常: " + e.getMessage());
            return res;
        }
    }

    @GetMapping("/getmessage")
    @ApiOperation("获取发帖内容")
    public List<chatotm> gettextmessage()
    {
        return chatService.getmessage();
    }

    @GetMapping("/gettextmessage")
    @ApiOperation("获取发帖对应评论内容")
    public List<comments> gettextmessage(@RequestParam("uid") Integer uid)
    {
        return chatService.gettextmessage(uid);
    }




}
