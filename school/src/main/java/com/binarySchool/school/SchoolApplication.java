package com.binarySchool.school;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.binarySchool.school.entity.Course;
import com.binarySchool.school.entity.Student;
import com.binarySchool.school.entity.Teacher;
import com.binarySchool.school.repository.CourseRepository;
import com.binarySchool.school.repository.StudentRepository;
import com.binarySchool.school.repository.TeacherRepository;

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner{
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private TeacherRepository teacherRepo;
	@Autowired
	private CourseRepository courseRepo;
	
	public static final Logger logger = (Logger) LoggerFactory.getLogger(SchoolApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Teacher t = new Teacher("Susan","Anthony");
		teacherRepo.save(t);
		
		Course c = new Course("Algebra 1", t);
		courseRepo.save(c);
		
		List<Student> st = Arrays.asList(
				new Student("Jane","Doe",Arrays.asList(c)),
				new Student("John","Smith",Arrays.asList(c))
				);
		studentRepo.saveAll(st);
		
		studentRepo.findAll().forEach(s->logger.info("Student added: {} {}",s.getFirstName(),s.getLastName()));
	}
	
}
