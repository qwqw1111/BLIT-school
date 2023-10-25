package com.binarySchool.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarySchool.school.entity.Student;
import com.binarySchool.school.exception.ResourceNotFoundException;
import com.binarySchool.school.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;
	
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student findStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found with id: "+id));
	}

	@Override
	public Student saveStudent(Student s) {
		// TODO Auto-generated method stub
		return studentRepo.save(s);
	}

	@Override
	public Student updateStudent(Student s) {
		// TODO Auto-generated method stub
		Student st = findStudentById(s.getId());
		st.setFirstName(s.getFirstName());
		st.setLastName(s.getLastName());
		s.setTeacher(s.getTeacher());
		studentRepo.save(s);
		return st;
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentRepo.delete(findStudentById(id));
	}

}
