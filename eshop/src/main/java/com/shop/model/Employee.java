package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")

public class Employee{

    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "Id")
    private long Id;


    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "password")
    private String password;


    @Column(name = "role")
    private String role;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String emailId,String password,String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.password = password;
        this.role = role;



    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee [id=" + Id + ", firstName=" + firstName +",lastName="+lastName+ ",emailId="+emailId+",password="+password+ "]";

    }
/*    public String getUser(String emailId, String password) throws Exception{

                StringBuilder selectQuery = new StringBuilder("select * from Employee where email_id="+emailId);

        return selectQuery.toString();
    }*/

}
