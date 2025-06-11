package com.tracker.task.repositories;

import com.tracker.task.entities.Task;
import com.tracker.task.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    //these methods are given by JpaRepositroy, if we needed extra, custom or according to our need, we need to create custom class


    //findBySatus
    //making customFinderMethods()


    //getting title according to task
    List<Task> findByTitle(String title); //findBy is mandatory, title is a field name, jpa write code automatically

    List<Task> findByStatus(TaskStatus status); //status is our field name from Task, this is rule

    List<Task> findByCreateAt(LocalDateTime localDateTime);
    //we are following pattern above
    //after findBy, they all are the name of entity

    List<Task> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    List<Task> findByTitleAndStatus(String title, TaskStatus status);

    List<Task> findByTitleContainingIgnoreCase(String titleKeyword);








}
