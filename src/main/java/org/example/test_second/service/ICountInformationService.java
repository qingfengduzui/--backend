package org.example.test_second.service;

import org.example.test_second.pojo.*;

import java.util.List;

public interface ICountInformationService {
    List<province> provincestudent();

    List<gender> genderstudent();

    List<education> educationstudent();

    List<interests> interestsstudent();

    List<political> politicalstudent();

    Integer countregisterstudent();
}
