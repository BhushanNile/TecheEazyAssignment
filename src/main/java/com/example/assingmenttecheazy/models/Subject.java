package com.example.assingmenttecheazy.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Subject extends BaseModel{
    private String name;
}
