package com.example.lab4.bd.bdclasses;

public class Unit {

    private int id;
    private String name;
    private String type;
    private int thermalCapacity;
    private double loadFactor;
    private double burnout;
    private int siteID;
    private double consumption;

    public Unit(int id, String unitName, String type, int thermalCapacity, double loadFactor, double burnout, int siteID) {
        this.id = id;
        this.name = unitName;
        this.type = type;
        this.thermalCapacity = thermalCapacity;
        this.loadFactor = loadFactor;
        this.burnout = burnout;
        this.siteID = siteID;
        setConsumption();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getThermalCapacity() {
        return thermalCapacity;
    }

    public void setThermalCapacity(int thermalCapacity) {
        this.thermalCapacity = thermalCapacity;
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(double loadFactor) {
        this.loadFactor = loadFactor;
    }

    public void setLoadFactor(int loadFactor) {
        this.loadFactor = loadFactor;
    }

    public double getBurnout() {
        return burnout;
    }

    public void setBurnout(double burnout) {
        this.burnout = burnout;
    }

    public void setConsumption() {
        this.consumption = thermalCapacity * loadFactor * 365 / (burnout * 100000);
    }

    public double getConsumption() {
        return consumption;
    }
}
