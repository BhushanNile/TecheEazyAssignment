package com.example.assingmenttecheazy.controllers;

import com.example.assingmenttecheazy.dtos.AddSubjectRequestDTO;
import com.example.assingmenttecheazy.dtos.AddSubjectResponceDto;
import com.example.assingmenttecheazy.models.Subject;
import com.example.assingmenttecheazy.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private  SubjectService subjectService;

       public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @PostMapping("/add")
    public AddSubjectResponceDto addSubject(@RequestBody AddSubjectRequestDTO requestDTO) {
            AddSubjectResponceDto responceDto = subjectService.addSubject(requestDTO);
        return responceDto;
    }

    @GetMapping("/get{name}" )
    public AddSubjectResponceDto getSubjects(@PathVariable("name") String name) {
        return subjectService.getSubject(name);

    }
    @GetMapping("/getall")
    public List<AddSubjectResponceDto> getAllSubjects() {
           return  subjectService.getAllSubjects();
    }


}
