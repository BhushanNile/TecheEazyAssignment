package com.example.assingmenttecheazy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Student extends BaseModel {
    private String name;
    private String address;
    @ManyToMany
    private List<Subject> subjects;
}
