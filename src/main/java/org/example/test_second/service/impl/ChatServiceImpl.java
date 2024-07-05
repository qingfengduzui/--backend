package org.example.test_second.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.test_second.mapper.chatotmMapper;
import org.example.test_second.pojo.result;
import org.example.test_second.pojo.table.chatotm;
import org.example.test_second.pojo.table.comments;
import org.example.test_second.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements IChatService {

    @Autowired
    private chatotmMapper chatotmmapper;

    @Override
    public List<chatotm> getmessage() {

        List<chatotm> message = chatotmmapper.getmessage();
        return message;
    }

    @Override
    public List<comments> gettextmessage(Integer uid) {
        List<comments> textmessage = chatotmmapper.gettextmessage(uid);
        return textmessage;
    }

    @Override
    public List<chatotm> getGoodsListByFilter(String filter) {
        QueryWrapper<chatotm> wrapper = new QueryWrapper<>();
        wrapper.like("message", filter);
        return chatotmmapper.selectList(wrapper);
    }
}
