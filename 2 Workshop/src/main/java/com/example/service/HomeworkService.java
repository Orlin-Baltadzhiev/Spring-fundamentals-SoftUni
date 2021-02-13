package com.example.service;

import org.springframework.stereotype.Service;

@Service
public interface HomeworkService {
    void addHomework(String exercise, String gitAddress);
}
