package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id")
    long id;
    @Column(name = "name")
    String name;
    @Column(name = "phoneNumber")
    String phoneNumber;
    @Column(name = "area")
    String area;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Customer() {
    }

    public Customer(String name,String phoneNumber,String area){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.area=area;

    }

    @Override
    public String toString() {
        return "Contacts [id=" + id + ",name=" + name +",phoneNumber="+phoneNumber+ ",area="+area+"]";

    }
}
