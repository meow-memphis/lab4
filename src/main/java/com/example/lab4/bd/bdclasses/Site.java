package com.example.lab4.bd.bdclasses;

public class Site {

    int id;
    String name;
    int countryID;
    int companyID;
    int col;

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = this.col+ col;
    }

    private double consumption;

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = this.consumption + consumption;
    }

    public Site(int id, String siteName, int countryID, int companyID) {
        this.id = id;
        this.name = siteName;
        this.countryID = countryID;
        this.companyID = companyID;
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

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
