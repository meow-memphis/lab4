package com.example.lab4.bd.bdclasses;

public class Site {

    int id;
    String siteName;
    int countryID;
    int companyID;

    public Site(int id, String siteName, int countryID, int companyID) {
        this.id = id;
        this.siteName = siteName;
        this.countryID = countryID;
        this.companyID = companyID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
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
