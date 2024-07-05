package org.example.test_second.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.example.test_second.mapper.accountMapper;
import org.example.test_second.mapper.chatotmMapper;
import org.example.test_second.pojo.*;
import org.example.test_second.pojo.table.*;
import org.example.test_second.service.impl.AuthServiceImpl;
import org.example.test_second.service.impl.ChatServiceImpl;
import org.example.test_second.utils.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private accountMapper accountmapper;

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
    public ResultTest testMessage(@RequestParam(name = "message") String message, String id){
        Integer subId = Integer.parseInt(id);
        if(id.equals(null))
        {
            return ResultTest.error(201,"用户未注册");
        }
        else {
            //数据插入表
            chatotmmapper.insertmessage(message, id);
            account elseinformation = chatotmmapper.insertelseinformation(subId);
            String nickname = elseinformation.getNickName();
            String fileData = elseinformation.getFileData();
            chatotmmapper.insertelsemessage(nickname, fileData, id);
            //发送实时单条信息
            webSocket.sendAllMessage(message, id);
            return ResultTest.success();
        }
    }

    @ApiOperation(value = "发帖点赞功能")
    @PostMapping("/textfavor")
    public result textfavor(@RequestBody textFavor textfavor)
    {
        Integer uid = textfavor.getUid();
        boolean iffavor = textfavor.isIfFavor();
        Integer id = textfavor.getId();
        result res = new result();
        if(id.equals(null))
        {
            res.setStatus(false);
            res.setResult("用户未注册");
            return res;
        }
        else {
            try {
                if (iffavor) {
                    String zh_message = "点赞";
                    webSocket.sendAllMessage(zh_message);
                    chatotmmapper.addfavor(id, uid);
                    Integer i = chatotmmapper.increasetextfavor(uid);
                    Integer countfavor = chatotmmapper.gettextfavor(uid);
                    res.setStatus(true);
                    res.setResult(countfavor);
                    return res;
                } else {
                    String zh_message = "取消点赞";
                    webSocket.sendAllMessage(zh_message);
                    chatotmmapper.deletefavor(id, uid);
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
    }

    @GetMapping("/search")
    public List<chatotm> searchGoods(@RequestParam("keyword") String keyword) {
        List<chatotm> pd=chatService.getGoodsListByFilter(keyword);
        return pd;
    }


    @ApiOperation(value = "发送全局回复消息")
    @PostMapping("sendcommentall")
    public ResultTest commentMessage(@RequestParam(name = "comment") String comment, Integer uid, Integer favor,Integer rid, Integer rcid){
        if(rid.equals(null))
        {
            return ResultTest.error(201,"用户未注册");
        }
        else {
            //数据插入表
            chatotmmapper.insertcommentmessage(comment, uid, rid, rcid, favor);
            Integer subId = rid;
            account elseinformation = chatotmmapper.insertelseinformation(subId);
            String nickname = elseinformation.getNickName();
            String fileData = elseinformation.getFileData();

            chatotmmapper.insertcommentelsemessage(nickname, fileData, rid);
            //发送实时单条信息
            webSocket.sendAllMessage(comment, uid, rid, rcid);
            chatotmmapper.commentsaddone(uid);
            return ResultTest.success();
        }
    }

    @ApiOperation(value = "更新")
    @GetMapping("updateWithNull")
    public void updatewithnull(){
        webSocket.sendAllMessage();
    }

    @ApiOperation(value = "评论点赞功能")
    @PostMapping("/commentfavor")
    public result commentfavor(@RequestBody commentfavor commentfavor)
    {
        Integer id = commentfavor.getId();
        Integer uid = commentfavor.getUid();
        boolean iffavor = commentfavor.isIfFavor();
        Integer cid = commentfavor.getCid();
        result res = new result();
        if(id.equals(null))
        {
            res.setStatus(false);
            res.setResult("用户未注册");
            return res;
        }
        else {
            try {
                if (iffavor) {
                    String zh_message = "点赞";
                    webSocket.sendAllMessage(zh_message);
                    chatotmmapper.addcommentfavor(id, uid, cid);
                    Integer i = chatotmmapper.increasecommentfavor(uid, cid);
                    Integer countfavor = chatotmmapper.getcommentfavor(uid, cid);
                    res.setStatus(true);
                    res.setResult(countfavor);
                    return res;
                } else {
                    String zh_message = "点赞";
                    webSocket.sendAllMessage(zh_message);
                    chatotmmapper.deletecommentfavor(id, uid, cid);
                    Integer i = chatotmmapper.decreasecommentfavor(uid, cid);
                    Integer countfavor = chatotmmapper.getcommentfavor(uid, cid);
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

    @PostMapping("/gettextfavor")
    @ApiOperation("获取发帖点赞")
    public List<favor> gettextfavor(@RequestBody gettextfavor gettextfavor)
    {
        Integer id = gettextfavor.getId();
        return chatotmmapper.gettextfavorbyid(id);
    }

    @PostMapping("/getcommentfavor")
    @ApiOperation("获取发帖评论对应评论点赞")
    public List<favorcomment> getcommentfavor(@RequestBody getcommentfavor getcommentfavor)
    {
        Integer id = getcommentfavor.getId();
        Integer uid = getcommentfavor.getUid();
        return chatotmmapper.getcommentfavorbyiduid(id, uid);
    }

    @ApiOperation("获取点赞数最高6个发帖")
    @GetMapping("/hotmessage")
    public List<chatotm> hotmessage()
    {
        return chatotmmapper.hotmessage();
    }



}
