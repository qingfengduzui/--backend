package org.example.test_second.service;

import org.example.test_second.pojo.result;
import org.example.test_second.pojo.table.chatotm;
import org.example.test_second.pojo.table.comments;

import java.util.List;

public interface IChatService {
    List<chatotm> getmessage();

    List<comments> gettextmessage(Integer uid);

    List<chatotm> getGoodsListByFilter(String keyword);
}
