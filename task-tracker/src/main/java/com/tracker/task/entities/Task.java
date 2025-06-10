package com.tracker.task.entities;

//here we will do mapping with the help of annotation

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity //first we make this class entity
@Table(name="jpa_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //naming the column of table, if this not given, default name will be the variable name
    @Column(name="task_name", length=100, nullable = false)
    private String title;

    @Column(name="task_description", length = 5000)
    private String content;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.PENDING;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime completedAt; //null at the beginning

    //creating getter and setter as all the variables are private


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
