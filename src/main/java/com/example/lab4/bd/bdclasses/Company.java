package com.example.lab4.bd.bdclasses;

public class Company {

    int id;
    String companyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Company(int id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }
}
