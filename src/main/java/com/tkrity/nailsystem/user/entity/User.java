package com.tkrity.nailsystem.user.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
public class User {

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

    public Long getId() {
        return id;
    }
    public String getUserCode(){
        return userCode;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ZonedDateTime getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
    //Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserCode(String name) {
        this.userCode = name;
    }

    public void setBirthDay(ZonedDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setAddress(String address){
        this.address = address;
    }

}
