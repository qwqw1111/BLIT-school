package com.binarySchool.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binarySchool.school.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
