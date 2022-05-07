package com.example.lab4.bd;

import com.example.lab4.bd.bdclasses.*;
import com.example.lab4.cast.Reactor;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class DBProvider {

    Connection connection;
    Statement statement;

    ArrayList<Unit> units = new ArrayList<>();
    ArrayList<Site> sites = new ArrayList<>();
    ArrayList<Company> companies = new ArrayList<>();
    ArrayList<Country> countries = new ArrayList<>();
    ArrayList<Region> regions = new ArrayList<>();

    public void connect(File file) throws SQLException {
        connection = DriverManager.getConnection("jdbc:ucanaccess://" + file.getAbsolutePath(), "", "");
        statement = connection.createStatement();
    }

    public void close() throws SQLException {
        connection.close();
    }

    ResultSet res(String tabName) throws SQLException {
        boolean A = statement.execute("SELECT * FROM " + tabName);
        return statement.getResultSet();
    }

    public void setAll(ArrayList<Reactor> reactorArrayList) throws SQLException {
        setUnits(res("units"), "units", reactorArrayList);
        setSites(res("sites"), "sites");
        setCompanies(res("companies"), "companies");
        setCountries(res("countries"), "countries");
        setRegions(res("regions"), "regions");
    }

    public void setUnits(ResultSet res, String tabName, ArrayList<Reactor> reactorArrayList) throws SQLException {

        while (res.next()) {

            if (res.getString(tabName + ".status").trim().equals("in operation")) {

                int id = res.getInt(tabName + ".id");
                String name = res.getString(tabName + ".unit_name").trim();
                String type = res.getString(tabName + ".type").trim();
                int thermalCapacity = res.getInt(tabName + ".thermal_capacity");
                double loadFactor;
                double burnup = 0;
                int siteID = res.getInt(tabName + ".site");
                if (res.getString(tabName + ".load_factor") != null) {
                    loadFactor = res.getDouble(tabName + ".load_factor");
                } else loadFactor = 90;

                for (Reactor reactor : reactorArrayList) {
                    if (reactor.getName().equals(type)) {
                        burnup = reactor.getBurnup();
                    }
                }
                if (burnup == 0) {
                    burnup = 42;
                }

                units.add(new Unit(id, name, type, thermalCapacity, loadFactor, burnup, siteID));
            }
        }
    }

    public void setSites(ResultSet res, String tabName) throws SQLException {

        while (res.next()) {

            if (res.getString(tabName + ".status").trim().equals("in operation")) {

                int id = res.getInt(tabName + ".id");
                String name = res.getString(tabName + ".npp_name").trim();
                int countryID = res.getInt(tabName + ".place");
                int companyID = res.getInt(tabName + ".operator");

                sites.add(new Site(id, name, countryID, companyID));
            }
        }
    }

    public void setCompanies(ResultSet res, String tabName) throws SQLException {

        while (res.next()) {
            int id = res.getInt(tabName + ".id");
            String name = res.getString(tabName + ".companies_name").trim();
            companies.add(new Company(id, name));
        }
    }

    public void setCountries(ResultSet res, String tabName) throws SQLException {

        while (res.next()) {
            int id = res.getInt(tabName + ".id");
            String name = res.getString(tabName + ".country_name").trim();
            int regionID = res.getInt(tabName + ".region_id");
            countries.add(new Country(id, name, regionID));
        }
    }

    public void setRegions(ResultSet res, String tabName) throws SQLException {

        while (res.next()) {
            int id = res.getInt(tabName + ".id");
            String name = res.getString(tabName + ".region_name").trim();
            regions.add(new Region(id, name));
        }
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public ArrayList<Site> getSites() {
        return sites;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }
}




