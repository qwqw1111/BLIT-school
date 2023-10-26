package com.binarySchool.school.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToOne
	private Teacher teacher;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Student> students;
	
	public Course() {
		
	}
	
	public Course(String n) {
		name = n;
	}
	
	public Course(String n, Teacher t) {
		name = n;
		teacher = t;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id) {
		this.id = id; 
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher t) {
		teacher = t;
	}
	
}
