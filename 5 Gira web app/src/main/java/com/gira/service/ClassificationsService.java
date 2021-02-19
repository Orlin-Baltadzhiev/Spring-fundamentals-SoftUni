package com.gira.service;

import com.gira.model.entities.Classification;
import com.gira.model.entities.enums.ClassificationNameEnum;
import org.springframework.stereotype.Service;

@Service
public interface ClassificationsService {
    void init();

    Classification findByName(ClassificationNameEnum classificationNameEnum);
}
