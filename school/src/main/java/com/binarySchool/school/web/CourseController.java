package com.binarySchool.school.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binarySchool.school.entity.Course;
import com.binarySchool.school.service.CourseService;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses(){
		return new ResponseEntity<>(courseService.getCourses(),HttpStatus.OK);
	}
	
}
