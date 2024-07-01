package org.example.test_second.service.impl;

import org.example.test_second.mapper.accountMapper;
import org.example.test_second.mapper.chatotmMapper;
import org.example.test_second.pojo.*;
import org.example.test_second.service.ICountInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountInformationServiceImpl implements ICountInformationService {

    @Autowired
    private accountMapper accountmapper;
    @Override
    public List<province> provincestudent() {
        List<province> provincecount = accountmapper.getprovincestudent();
        return provincecount;
    }

    @Override
    public List<gender> genderstudent() {
        List<gender> gendercount = accountmapper.getgenderstudent();
        return gendercount;
    }

    @Override
    public List<education> educationstudent() {
        List<education> educationcount = accountmapper.geteducationstudent();
        return educationcount;
    }

    @Override
    public List<interests> interestsstudent() {
        List<interests> interestscount = accountmapper.getinterestsstudent();
        return interestscount;
    }

    @Override
    public List<political> politicalstudent() {
        List<political> politicalcount = accountmapper.getpoliticalstudent();
        return politicalcount;
    }

    @Override
    public Integer countregisterstudent() {
        return accountmapper.countregisterstudent();
    }
}
