package com.example.assingmenttecheazy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class Session extends  BaseModel{
    private String token;
    private Instant expiredAt;
    @ManyToOne
    private User user;


}
