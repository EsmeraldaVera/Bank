package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private int account;
    private int pin;
    private int balance;


    public Customer(int account, int pin, int balance) {
        this.account = account;
        this.pin = pin;
        this.balance = balance;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int id) {
        this.customerId = customerId;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getPin(){
        return pin;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance= balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", account='" + account + '\'' +
                ", pin=" + pin +
                ", balance='"+ balance + '\''+
                '}';
    }
}
