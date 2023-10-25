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

import com.binarySchool.school.entity.Teacher;
import com.binarySchool.school.service.TeacherService;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/teachers")
	public ResponseEntity<List<Teacher>> getAllTeachers(){
		return new ResponseEntity<>(teacherService.getTeachers(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher t){
		return new ResponseEntity<>(teacherService.saveTeacher(t),HttpStatus.CREATED);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher t, @PathVariable Long id){
		return new ResponseEntity<>(teacherService.updateTeacher(t),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Teacher> findTeacher(@PathVariable Long id){
		return new ResponseEntity<>(teacherService.findTeacherById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id){
		teacherService.deleteTeacher(id);
		return new ResponseEntity<Teacher>(HttpStatus.ACCEPTED);
	}
}
