package com.tracker.task.entities;

import jakarta.persistence.*;


@Entity // we marked this class an Entity so that we  can map to our database, the name of the class is the name of table by default in database
@Table(name="jpa_students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;


    //A student has certificate
    //here we can do mapping using annotation
    @OneToOne(mappedBy="student")
    private Certificate certificate;

    //i need to do many to one
    @ManyToOne
    //if we want to change the name of column
    @JoinColumn(name = "department_id")
    private Department department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
}
