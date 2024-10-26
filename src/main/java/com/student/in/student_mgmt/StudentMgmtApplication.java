package com.student.in.student_mgmt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentMgmtApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApplication.class, args);
	}

	// @Autowired
	// private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		// Student student1 = new Student("Vamsi", "Krishna", "vamsi@gmail.com");
		// studentRepository.save(student1);
		// Student student2 = new Student("Sai", "Ram", "sairam@gmail.com");
		// studentRepository.save(student2);
		// Student student3 = new Student("Nikhil", "Kumar", "nikhilkumar@gmail.com");
		// studentRepository.save(student3);
	}

}
