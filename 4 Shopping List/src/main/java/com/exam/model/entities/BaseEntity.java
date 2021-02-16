package com.exam.model.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {


    private String id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(generator = "uuid-String")
    @GenericGenerator(
            name = "uuid-String",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    public String getId() {
        return id;
    }

    public BaseEntity setId(String id) {
        this.id = id;
        return this;
    }
}
