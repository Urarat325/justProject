package com.yuriityshchuk.justproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Subject extends BaseEntity {

    @Column(unique = true)
    @NotBlank(message = "subject cannot be empty")
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
