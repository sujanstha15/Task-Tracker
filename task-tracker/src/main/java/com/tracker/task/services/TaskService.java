package com.tracker.task.services;

import com.tracker.task.entities.Task;
import com.tracker.task.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    //writing some logic to save task

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task){//adding task in parameter as it is the one which is need to be saved
        //logic to save task


        Task savedTask = taskRepository.save(task);
        System.out.println("Task save with Id: "+ savedTask.getId());
        return savedTask;




    }

}
