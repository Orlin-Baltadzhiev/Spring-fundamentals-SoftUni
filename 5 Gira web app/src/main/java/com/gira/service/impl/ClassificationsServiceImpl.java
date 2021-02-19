package com.gira.service.impl;

import com.gira.model.entities.Classification;
import com.gira.model.entities.enums.ClassificationNameEnum;
import com.gira.repositories.ClassificationRepository;
import com.gira.service.ClassificationsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class ClassificationsServiceImpl implements ClassificationsService {
    private final ClassificationRepository classificationRepository;

    public ClassificationsServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void init() {
        if(classificationRepository.count()==0){
            Arrays.stream(ClassificationNameEnum.values())
                    .forEach(e -> {
                        Classification classification = new Classification(e, "Description for " + e );
                        classificationRepository.saveAndFlush(classification);
                    });
        }

    }

    @Override
    public Classification findByName(ClassificationNameEnum classificationNameEnum) {
        return classificationRepository.findFirstByClassificationNameEnum(classificationNameEnum);

    }
}
