package com.binarySchool.school.service;

import java.util.List;

import com.binarySchool.school.entity.Course;

public interface CourseService {
	List<Course> getCourses();
	Course findCourseById(Long id);
	Course saveCourse(Course c);
	Course updateCourse(Course c);
	void deleteCourse(Long id);
}
