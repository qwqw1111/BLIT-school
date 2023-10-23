package com.binarySchool.school;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.binarySchool.school.entity.Student;
import com.binarySchool.school.entity.Teacher;
import com.binarySchool.school.repository.studentRepository;
import com.binarySchool.school.repository.teacherRepository;

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner{
	@Autowired
	private studentRepository studentRepo;
	@Autowired
	private teacherRepository teacherRepo;
	
	public static final Logger logger = (Logger) LoggerFactory.getLogger(SchoolApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Teacher t = new Teacher("Susan","Anthony");
		teacherRepo.save(t);
		
		List<Student> st = Arrays.asList(
				new Student("Jane","Doe",t),
				new Student("John","Smith",t)
				);
		studentRepo.saveAll(st);
		
		studentRepo.findAll().forEach(s->logger.info("Student added: {} {}",s.getFirstName(),s.getLastName()));
	}
	
}
