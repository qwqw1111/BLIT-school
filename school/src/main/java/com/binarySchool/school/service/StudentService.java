package com.binarySchool.school.service;

import java.util.List;

import com.binarySchool.school.entity.Student;

public interface StudentService {

	List<Student> getStudents();
	Student findStudentById(Long id);
	Student saveStudent(Student s);
	Student updateStudent(Student s);
	void deleteStudent(Long id);
	
}
