package com.tracker.task.repositories;

import com.tracker.task.entities.Task;
import com.tracker.task.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    //these methods are given by JpaRepositroy, if we needed extra, custom or according to our need, we need to create custom class


    //findBySatus
    //they all are  custom method / custom finder methods
    //making customFinderMethods()
    //getting title according to task
    List<Task> findByTitle(String title); //findBy is manda tory, title is a field name, jpa write code automatically

    List<Task> findByStatus(TaskStatus status); //status is our field name from Task, this is rule

    List<Task> findByCreatedAt(LocalDateTime localDateTime);
    //we are following pattern above
    //after findBy, they all are the name of entity

    List<Task> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

    List<Task> findByTitleAndStatus(String title, TaskStatus status);

    List<Task> findByTitleContainingIgnoreCase(String titleKeyword);



    //query methods -- custom query
    //there is no specific rule

    @Query("SELECT t FROM Task t")
    List<Task> getAllTask1();

    @Query("SELECT t from Task t WHERE t.id = :id and t.status = :status")
    Task getById(@Param("id") long id, @Param("status") TaskStatus status);

    //native query is database dependent, only used when data base related activity is heavy 
    @NativeQuery("SELECT * FROM jpa-Tasks")
    List<Task> getAllTask2();




}
