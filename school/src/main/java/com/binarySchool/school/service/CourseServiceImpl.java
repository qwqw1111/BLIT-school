package com.binarySchool.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarySchool.school.entity.Course;
import com.binarySchool.school.exception.ResourceNotFoundException;
import com.binarySchool.school.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepo;
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public Course findCourseById(Long id) {
		// TODO Auto-generated method stub
		return courseRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Course not found with id: "+id));
	}

	@Override
	public Course saveCourse(Course c) {
		// TODO Auto-generated method stub
		return courseRepo.save(c);
	}

	@Override
	public Course updateCourse(Course c) {
		// TODO Auto-generated method stub
		Course co = findCourseById(c.getId());
		co.setName(c.getName());
		courseRepo.save(co);
		return co;
	}

	@Override
	public void deleteCourse(Long id) {
		// TODO Auto-generated method stub
		courseRepo.delete(findCourseById(id));
		//courseRepo.deleteById(id);
	}

}
