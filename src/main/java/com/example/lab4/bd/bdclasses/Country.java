package com.example.lab4.bd.bdclasses;

public class Country {

    int id;
    String name;
    int regionID;

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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public Country(int id, String name, int regionID) {
        this.id = id;
        this.name = name;
        this.regionID = regionID;
    }
}
