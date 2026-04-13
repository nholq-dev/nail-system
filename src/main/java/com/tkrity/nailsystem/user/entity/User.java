package com.tkrity.nailsystem.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
@Entity
public class User {

    //Setter
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false,unique = true)
    private String userCode;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private ZonedDateTime birthDay;

    @Column
    private String password;

    @Column
    private String address;

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

}
