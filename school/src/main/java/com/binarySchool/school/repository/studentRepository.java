package com.binarySchool.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.binarySchool.school.entity.Student;

@Repository
public interface studentRepository extends CrudRepository<Student, Long> {
	
}
