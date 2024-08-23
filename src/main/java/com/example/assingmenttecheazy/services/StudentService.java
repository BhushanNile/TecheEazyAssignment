package com.example.assingmenttecheazy.services;

import com.example.assingmenttecheazy.dtos.StudentRequestDTO;
import com.example.assingmenttecheazy.dtos.StudentResponseDTO;
import com.example.assingmenttecheazy.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    StudentResponseDTO getStudent(long id ) throws StudentNotFoundException;

    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO);
}
