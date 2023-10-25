package com.binarySchool.school.service;

import java.util.List;

import com.binarySchool.school.entity.Teacher;

public interface TeacherService {
	List<Teacher> getTeachers();
	Teacher findTeacherById(Long id);
	Teacher saveTeacher(Teacher t);
	Teacher updateTeacher(Teacher t);
	void deleteTeacher(Long id);
}
