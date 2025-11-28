package org.example.thuc_hanh2.entity;

import java.time.LocalDate;

public class Customer {
    private Integer id;
    private String name;
    private LocalDate date;
    private String address;

    public Customer(){

    }

    public Customer(Integer id, String name, LocalDate date, String address) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
