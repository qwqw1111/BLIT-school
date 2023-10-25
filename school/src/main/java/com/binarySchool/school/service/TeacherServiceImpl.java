package com.binarySchool.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarySchool.school.entity.Teacher;
import com.binarySchool.school.exception.ResourceNotFoundException;
import com.binarySchool.school.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepo;
	
	@Override
	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		return teacherRepo.findAll();
	}

	@Override
	public Teacher findTeacherById(Long id) {
		// TODO Auto-generated method stub
		return teacherRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Teacher not found with id: "+id));
	}

	@Override
	public Teacher saveTeacher(Teacher t) {
		// TODO Auto-generated method stub
		return teacherRepo.save(t);
	}

	@Override
	public Teacher updateTeacher(Teacher t) {
		// TODO Auto-generated method stub
		Teacher te = findTeacherById(t.getId());
		te.setFirstName(t.getFirstName());
		te.setLastName(t.getLastName());
		teacherRepo.save(te);
		return te;
	}

	@Override
	public void deleteTeacher(Long id) {
		// TODO Auto-generated method stub
		teacherRepo.delete(findTeacherById(id));
	}

}
