package com.tracker.task.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jpa_department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    private String name;

    private String code;

    //private Student student;, if we do this, then we can only store one student
    //so we have to use List(collection) to store the list of students
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZ) // we want to add column in Student table for Department field
    //an extra column of depratment will be added in Student table
     private List<Student> students = new ArrayList<>();//since we have dony mapped by department, there wlil be no column for student


}
