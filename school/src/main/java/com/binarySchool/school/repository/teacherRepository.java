package com.binarySchool.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.binarySchool.school.entity.Teacher;

@Repository
public interface teacherRepository extends CrudRepository<Teacher, Long> {

}
