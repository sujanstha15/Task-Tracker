package com.tracker.task.services;

import com.tracker.task.entities.Task;
import com.tracker.task.entities.TaskStatus;
import com.tracker.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    //writing some logic to save task

    @Autowired
    private TaskRepository taskRepository;


    //save task logic
    public Task saveTask(Task task){//adding task in parameter as it is the one which is need to be saved
        //logic to save task

        task.setStatus(TaskStatus.IN_PROGRESS);
        task.setCreatedAt(task.getCreatedAt().minusDays(4));


        Task savedTask = taskRepository.save(task);
        System.out.println("Task save with Id: "+ savedTask.getId());
        return savedTask;

    }

    //update logic here

    //get all task
    public List<Task> getAll(){
        List<Task> tasks = taskRepository.findAll(); //we get all the task, it's built in method of JpaRepository
        //if we need to use database, then we need to call repository layer
        return tasks;
    }
    //get task by Id
    public Task getById(long id){
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found with: " + id));
        return task;
    }
    //delete task by ID
    public void deleteById(long id){

        //first get the task and then delete
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found with: " + id));
        taskRepository.delete(task);

    }
    //get all task by status

    public List<Task> getByStatus(TaskStatus status){
        //there is no method findByStatus() as this is custom

        List<Task> byStatus = taskRepository.findByStatus(status);
        return byStatus;


    }
    //get all task by date
    public List<Task> getCreatedDate(LocalDateTime createdAt){

        List<Task> byCreatedAt = taskRepository.findByCreatedAt(createdAt);
        return byCreatedAt;
    }

    //search task
    public List<Task> searchByTitle(String titleKeyword){
        List<Task> tasks = taskRepository.findByTitleContainingIgnoreCase(titleKeyword);
        return tasks;
    }

    public List<Task> getByCreatedDateBetween(LocalDateTime  start, LocalDateTime end){

        List<Task> byCreatedAt = taskRepository.findByCreatedAtBetween(start, end);
        return byCreatedAt;
    }
}
