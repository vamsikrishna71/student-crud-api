package com.student.in.student_mgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.student.in.student_mgmt.entity.Student;
import com.student.in.student_mgmt.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    // Handler Method to handle list students and return model and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // This is the view name that we want to render and return to the client. It
                           // should match with the view file in templates folder.
    }

    @GetMapping("/students/new")
    public String createStudent(Model model) {
        // Create Student Object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student"; // this is the view name that we want to render and return to the client.
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students"; // This is the view name that we want to render and return to the client.
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {

        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student"; // This is the view name that we want to render and return to the client.
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("students") Student student, Model model) {
        // Get student from database by ID
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        // Save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students"; // This is the view name that we want to render and return to the client.
    }

    // Handler method to handle delete request for a student
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students"; // this is the view name that we want to render and return to the client.
    }
}
