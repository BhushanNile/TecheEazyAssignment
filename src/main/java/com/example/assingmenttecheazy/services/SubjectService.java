package com.example.assingmenttecheazy.services;

import com.example.assingmenttecheazy.dtos.AddSubjectRequestDTO;
import com.example.assingmenttecheazy.dtos.AddSubjectResponceDto;
import com.example.assingmenttecheazy.exceptions.SubjectNotFoundException;

import java.util.List;

public interface SubjectService {

    AddSubjectResponceDto addSubject(AddSubjectRequestDTO requestDTO);
    AddSubjectResponceDto getSubject(String name) throws SubjectNotFoundException;
    List<AddSubjectResponceDto> getAllSubjects() ;
 }

