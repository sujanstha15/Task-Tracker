package com.tracker.task.repositories;

import com.tracker.task.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    private EntityManager entityManager;

    //writing logic here
    public void getStudents(){
        System.out.println("Getting student");

        //implement criteria api for getting students

        //get criteria builder
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //create criteria query
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

        //defining roo
        //root represent from clause of db/ table/entity
        Root<Student> root = criteriaQuery.from(Student.class);

        //build conditions using predicate
        //predicate is from builder
        Predicate predicate = criteriaBuilder.equal(root.get("name"), "Sujan");


        //build
        criteriaQuery.select(root).where(predicate);

        //to fireup, use entity manager
        //select karegne data
       Student student = entityManager.createQuery(criteriaQuery).getSingleResult();

        System.out.println(student);


    }
}
