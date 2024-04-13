package com.yaroslav.students.controller;


import com.yaroslav.students.model.Student;
import com.yaroslav.students.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v/students")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private StudentService studentService;


    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("save_student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email){
        return studentService.findByEmail(email);
    }

    @PutMapping("/update_student")
    public Student updateStudent(Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete_student/{email}")
    public void deleteStudent(@PathVariable String email){
        studentService.deleteStudent(email);
    }
}
