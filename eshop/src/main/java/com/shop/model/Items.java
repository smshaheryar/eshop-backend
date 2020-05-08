package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Items {

    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "id")
    long id;
    @Column(name = "item")
    String item;
    @Column(name ="price")
    String price;
    @Column(name = "quantity")
    String quantity;
     @Column(name="company")
    String company;
    @Column(name="size")
    String size;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public Items() {
    }

    public Items(String item , String price, String quantity,String company,String size) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.company = company;
        this.size = size;
    }
    @Override
    public String toString() {
        return "items [id=" + id + ",item=" + item +",price="+price+ ",quantity="+quantity+",company="+company+",size="+size+"]";

    }


}
