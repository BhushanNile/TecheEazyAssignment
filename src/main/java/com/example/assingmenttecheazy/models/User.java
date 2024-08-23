package com.example.assingmenttecheazy.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel{

    private String userName;
    private String password;
    private String email;
    @OneToOne
    private Role role;

}
