package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Supplier")
public class Supplier {


    @javax.persistence.Id
    @GeneratedValue
    @Column(name = "Id")
    private long Id;


    @Column(name = "Name")
    private String name;

    @Column(name = "Items")
    private String items;

    @Column(name = "Last_payment_date")
    private Date lastPaymentDate;

    @Column(name = "Remain_balance")
        private String remainingBalance;

    @Column(name = "Total_balance")
    private String totalBalance;

    @Column(name = "Last_payment")
    private String lastPayment;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public String getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(String remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(String lastPayment) {
        this.lastPayment = lastPayment;
    }




    public Supplier() {

    }

    public Supplier(String name, String items, String remainingBalance,String totalBalance,String lastPayment,Date lastPaymentDate) {
        this.name = name;
        this.items = items;
        this.remainingBalance = remainingBalance;
        this.totalBalance = totalBalance;
        this.lastPayment = lastPayment;
        this.lastPaymentDate = lastPaymentDate;

    }
    @Override
    public String toString() {
        return "Employee [id=" + Id + ", name=" + name +",items="+items+ ",remainingBalance="+remainingBalance
                +",totalBalance="+totalBalance+",lastPayment="+lastPayment+",lastPaymentDate="+lastPaymentDate+ "]";

    }

}
