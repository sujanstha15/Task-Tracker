package com.tracker.task;

import com.tracker.task.entities.Certificate;
import com.tracker.task.entities.Student;
import com.tracker.task.repositories.CertificateRepo;
import com.tracker.task.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TaskTrackerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackerApplication.class, args);
	}


	//Using @Autowired for dependency Injection

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private CertificateRepo certificateRepo;

	@Override
	public void run(String... args) throws Exception{

		/*

		//going to save student and certificate
		Student student = new Student();
		student.setEmail("sarhtak@gmail.com");
		student.setName("Sarthak");


		Certificate certificate = new Certificate();
		certificate.setTitle("Java Certificatoin");
		certificate.setDescription("This is java certifdication");
		certificate.setIssuedAt(LocalDate.now());


		Student savedStudent = studentRepo.save(student);
		System.out.println("Student saved successfully. ");

		savedStudent.setCertificate(certificate);
		certificate.setStudent(savedStudent);


		certificateRepo.save(certificate);
		System.out.println("Certificate also saved");*/
	}
}
