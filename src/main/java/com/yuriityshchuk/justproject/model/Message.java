package com.yuriityshchuk.justproject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Message extends BaseEntity {
    @NotBlank
    private String course;

    @NotBlank
    private String semester;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Subject subject;

    @NotBlank
    private String message;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customers_id")
    private Customer customers;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DBFile> dbFile;

    public Message() {
    }

    public Message(String course, String semester, String message, Customer customers) {
        this.course = course;
        this.semester = semester;
        this.message = message;
        this.customers = customers;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public List<DBFile> getDbFile() {
        return dbFile;
    }

    public void setDbFile(List<DBFile> dbFile) {
        this.dbFile = dbFile;
    }
}
