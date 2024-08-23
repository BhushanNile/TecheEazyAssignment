package com.example.assingmenttecheazy.repositories;

import com.example.assingmenttecheazy.dtos.AddSubjectResponceDto;
import com.example.assingmenttecheazy.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepositories extends JpaRepository<Subject, Long> {
    Optional<Subject> findByName(String name);
}
