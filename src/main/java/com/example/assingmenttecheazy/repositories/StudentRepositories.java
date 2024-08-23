package com.example.assingmenttecheazy.repositories;

import com.example.assingmenttecheazy.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepositories extends JpaRepository<Student, Long> {



}
