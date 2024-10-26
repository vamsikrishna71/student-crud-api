package com.student.in.student_mgmt.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.student.in.student_mgmt.entity.Student;
import com.student.in.student_mgmt.service.StudentService;

import static org.mockito.Mockito.*;

public class StudentControllerTest {
    private StudentService studentService;
    private StudentController studentController;

    @BeforeEach
    void setUp() {
        studentService = mock(StudentService.class);
        studentController = new StudentController(studentService); // Assuming StudentController constructor accepts
                                                                   // StudentService
    }

    @Test
    void saveStudentTest() {
        // Arrange
        Student student = new Student();

        // Act
        studentController.saveStudent(student);

        // Assert (using Mockito's verify method)
        verify(studentService).saveStudent(student);
    }
}
