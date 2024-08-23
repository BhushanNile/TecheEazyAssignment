package com.example.assingmenttecheazy.services;

import com.example.assingmenttecheazy.dtos.StudentRequestDTO;
import com.example.assingmenttecheazy.dtos.StudentResponseDTO;
import com.example.assingmenttecheazy.exceptions.StudentNotFoundException;
import com.example.assingmenttecheazy.models.Student;
import com.example.assingmenttecheazy.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
     private StudentRepositories studentRepositories;

    public StudentServiceImpl(StudentRepositories studentRepositories) {
        this.studentRepositories = studentRepositories;
    }

    public StudentResponseDTO convertStudentToResponseDTO(Student student) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setStudent_id(student.getId());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setAddress(student.getAddress());
        return studentResponseDTO;
    }

    @Override
    public StudentResponseDTO getStudent( long id) throws StudentNotFoundException {
        Optional<Student> studentOptional =  studentRepositories.findById(id);
        if (studentOptional.isEmpty()) {
            throw  new StudentNotFoundException("Student is not found");
        }

        StudentResponseDTO studentResponseDTO = convertStudentToResponseDTO(studentOptional.get());
        return studentResponseDTO;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepositories.findAll();
        List<StudentResponseDTO> studentResponseDTOS = new ArrayList<>();
        for (Student student : students) {
            studentResponseDTOS.add(convertStudentToResponseDTO(student));
        }
        return studentResponseDTOS;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setAddress(studentRequestDTO.getAddress());
        studentRepositories.save(student);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setStudent_id(student.getId());
        studentResponseDTO.setName(studentRequestDTO.getName());
        studentResponseDTO.setAddress(studentRequestDTO.getAddress());

        return studentResponseDTO;
    }
}
