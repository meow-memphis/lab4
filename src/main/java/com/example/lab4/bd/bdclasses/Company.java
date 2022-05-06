package com.example.lab4.bd.bdclasses;

public class Company {

    int id;
    String Name;

    private double consumption;

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = this.consumption + consumption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Company(int id, String Name) {
        this.id = id;
        this.Name = Name;
    }
}
