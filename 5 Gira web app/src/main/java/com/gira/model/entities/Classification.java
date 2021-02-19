package com.gira.model.entities;

import com.gira.model.entities.enums.ClassificationNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "Classification")
public class Classification extends BaseEntity {

    private ClassificationNameEnum classificationNameEnum;
    private String description;

    public Classification() {
    }

    public Classification(ClassificationNameEnum classificationNameEnum, String description) {
        this.classificationNameEnum = classificationNameEnum;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public ClassificationNameEnum getClassificationNameEnum() {
        return classificationNameEnum;
    }

    public Classification setClassificationNameEnum(ClassificationNameEnum classificationNameEnum) {
        this.classificationNameEnum = classificationNameEnum;
        return this;
    }
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
