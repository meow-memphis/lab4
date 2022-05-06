package com.example.lab4.bd.bdclasses;

public class Country {

    int id;
    String countryName;
    int regionID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public Country(int id, String countryName, int regionID) {
        this.id = id;
        this.countryName = countryName;
        this.regionID = regionID;
    }
}
