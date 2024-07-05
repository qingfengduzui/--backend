package org.example.test_second.service.impl;

import org.example.test_second.mapper.accountMapper;
import org.example.test_second.mapper.courseMapper;
import org.example.test_second.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements ICourseService {


    @Autowired
    private courseMapper coursemapper;
}
