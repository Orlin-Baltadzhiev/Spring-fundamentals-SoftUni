package com.gira.repositories;

import com.gira.model.entities.Classification;
import com.gira.model.entities.enums.ClassificationNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, String> {


    Classification findFirstByClassificationNameEnum(ClassificationNameEnum classificationNameEnum);

}
