package com.example.assingmenttecheazy.services;

import com.example.assingmenttecheazy.dtos.AddSubjectRequestDTO;
import com.example.assingmenttecheazy.dtos.AddSubjectResponceDto;
import com.example.assingmenttecheazy.exceptions.SubjectNotFoundException;
import com.example.assingmenttecheazy.models.Subject;
import com.example.assingmenttecheazy.repositories.SubjectRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepositories subjectRepositories;

    public SubjectServiceImpl(SubjectRepositories subjectRepositories) {
        this.subjectRepositories = subjectRepositories;
    }

    public AddSubjectResponceDto converSubjectTOResponceDTO(Subject subject) {
        AddSubjectResponceDto responceDto = new AddSubjectResponceDto();
        responceDto.setSubjectName(subject.getName());
        responceDto.setId(subject.getId());
        return responceDto;
    }



    @Override
    public AddSubjectResponceDto addSubject(AddSubjectRequestDTO requestDTO) {
        Subject subject = new Subject();
        subject.setName(requestDTO.getSubjectName());
        subjectRepositories.save(subject);
        AddSubjectResponceDto addSubjectResponceDto = new AddSubjectResponceDto();
        addSubjectResponceDto.setId(subject.getId());
        addSubjectResponceDto.setSubjectName(subject.getName());

        return  addSubjectResponceDto;
    }
    @Override
    public AddSubjectResponceDto getSubject(String name) throws SubjectNotFoundException {
        Optional<Subject> subjectOptional= subjectRepositories.findByName(name);
        if(subjectOptional.isEmpty()){
            throw new SubjectNotFoundException("Subject not found");
        }
        return converSubjectTOResponceDTO(subjectOptional.get());
    }

    @Override
    public List<AddSubjectResponceDto> getAllSubjects() {
        List<Subject> subjectList = subjectRepositories.findAll();
        ArrayList<AddSubjectResponceDto> addSubjectResponceDtoList = new ArrayList<>();

        for( Subject subject : subjectList ){
            AddSubjectResponceDto addSubjectResponceDto = converSubjectTOResponceDTO(subject);
            addSubjectResponceDtoList.add(addSubjectResponceDto);
        }

        return addSubjectResponceDtoList;
    }
}
