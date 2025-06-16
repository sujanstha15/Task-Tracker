package com.tracker.task;

import com.tracker.task.entities.*;
import com.tracker.task.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

	@Autowired //we are doing autowired so that we can get that object
	private DepartmentRepo departmentRepo;


	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private CategoryRepo categoryRepo;
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
//		Student student = studentRepo.findById(5).get();
//		System.out.println(student.getName());
//
//		Certificate certificate = student.getCertificate();
//		System.out.println(certificate.getTitle());
//		//the above two, we can do vice-versa

//create a department
//		Department department = new Department();
//		department.setName("CSE");
//		department.setCode("CS101");
//
//		//creating many students under department
//		Student student1 = new Student();
//		student1.setName("Sujan Shrestha");
//		student1.setEmail("shresthas4");
//		student1.setDepartment(department);
//
//		Student student2 = new Student();
//		student2.setName("Yashoda Dangal");
//		student2.setEmail("dangalyd");
//		student2.setDepartment(department);
//
//		List<Student> studentList = new ArrayList<>();
//		studentList.add(student1);
//		studentList.add(student2);
//
//		department.setStudents(studentList);
//
//		Department savedDepartment =  departmentRepo.save(department);
//
//		System.out.println("Department created");



//creating category
		Category category1 = new Category();
		category1.setTitle("Trending)");

		Category category2 = new Category();
		category2.setTitle("Mobile Phones");

		Product product1 = new Product();
		product1.setName("Iphone 13");

		Product product2  = new Product();
		product2.setName("Hp Pavallion");

		//mapping these and then save

		//to save, we need productRepo and categoryRepo

		//mapping
		product1.getCategories().add(category1);
		product1.getCategories().add(category2);

		category1.getProducts().add(product1);
		category2.getProducts().add(product1);

		product2.getCategories().add(category1);
		category1.getProducts().add(product2);

		//save
		productRepo.save(product1);
		productRepo.save(product2);//we are just saving the product only because, the Categories will be automaitcally updated as we have used CascadeALl

















	}
}
