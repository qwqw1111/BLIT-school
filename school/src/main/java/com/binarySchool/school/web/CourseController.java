package com.binarySchool.school.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Course> findCourse(@PathVariable Long id){
		return new ResponseEntity<>(courseService.findCourseById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Course> addCourse(@RequestBody Course c){
		return new ResponseEntity<>(courseService.saveCourse(c),HttpStatus.CREATED);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<Course> updateCourse(@RequestBody Course c, @PathVariable Long id){
		return new ResponseEntity<>(courseService.updateCourse(c),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
		courseService.deleteCourse(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
