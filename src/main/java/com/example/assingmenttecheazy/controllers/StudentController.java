package com.example.assingmenttecheazy.controllers;

import com.example.assingmenttecheazy.dtos.StudentRequestDTO;
import com.example.assingmenttecheazy.dtos.StudentResponseDTO;
import com.example.assingmenttecheazy.models.Student;
import com.example.assingmenttecheazy.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    @Autowired
    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/get{id}")
    public StudentResponseDTO getStudent(@PathVariable ("id") long id) {
        StudentResponseDTO studentResponseDTO = studentService.getStudent(id);
        return studentResponseDTO;
    }
    @GetMapping("/getall")
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();

    }

    @PostMapping("/add")
    public StudentResponseDTO addStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        StudentResponseDTO studentResponseDTO = studentService.createStudent(studentRequestDTO);
        return studentResponseDTO;
    }


}
