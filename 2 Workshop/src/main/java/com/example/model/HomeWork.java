package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "homework")
public class HomeWork extends BaseEntity {

    @Column(name = "added_on")
    private LocalDateTime addedOn;

    @Column(name = "git_addres")
    private String gitAddress;


    @ManyToOne
    private User author;


    @ManyToOne
    private Exercise exercise;

    public HomeWork() {
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Exercise getExecise() {
        return exercise;
    }

    public void setExecise(Exercise exercise) {
        this.exercise = exercise;
    }
}
