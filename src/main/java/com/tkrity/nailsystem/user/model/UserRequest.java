package com.tkrity.nailsystem.user.model;


public class UserRequest {

    private String userCode;


    private String firstName;

    private String lastName;


    private String birthDay;


    private String password;

    private String address;

    public String getUserCode(){
        return userCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }


    public void setUserCode(String name) {
        this.userCode = name;
    }

    public void setBirthDay(String birthDay) {
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
