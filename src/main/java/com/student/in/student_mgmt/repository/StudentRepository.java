package com.student.in.student_mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.in.student_mgmt.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
