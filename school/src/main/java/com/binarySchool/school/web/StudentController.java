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

import com.binarySchool.school.entity.Student;
import com.binarySchool.school.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<Student> findStudent(@PathVariable Long id){
		return new ResponseEntity<>(studentService.findStudentById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student s){
		return new ResponseEntity<>(studentService.saveStudent(s), HttpStatus.CREATED);
	}

	@PutMapping("id/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student s, @PathVariable Long id){
		return new ResponseEntity<>(studentService.updateStudent(s),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
