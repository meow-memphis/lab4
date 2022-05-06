package com.example.lab4.cast;

public class Reactor {

    private String name;
    private double burnup;
    private double kpd;
    private double enrichment;
    private double thermalCapacity;
    private double electricalCapacity;
    private double lifeTime;
    private double firstLoad;

    public Reactor(String name, double burnup, double kpd, double enrichment, double thermalCapacity, double electricalCapacity, double lifeTime, double firstLoad) {
        this.name = name;
        this.burnup = burnup;
        this.kpd = kpd;
        this.enrichment = enrichment;
        this.thermalCapacity = thermalCapacity;
        this.electricalCapacity = electricalCapacity;
        this.lifeTime = lifeTime;
        this.firstLoad = firstLoad;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBurnup() {
        return burnup;
    }

    public void setBurnup(double burnup) {
        this.burnup = burnup;
    }

    public double getKpd() {
        return kpd;
    }

    public void setKpd(double kpd) {
        this.kpd = kpd;
    }

    public double getEnrichment() {
        return enrichment;
    }

    public void setEnrichment(double enrichment) {
        this.enrichment = enrichment;
    }

    public double getThermalCapacity() {
        return thermalCapacity;
    }

    public void setThermalCapacity(double thermalCapacity) {
        this.thermalCapacity = thermalCapacity;
    }

    public double getElectricalCapacity() {
        return electricalCapacity;
    }

    public void setElectricalCapacity(double electricalCapacity) {
        this.electricalCapacity = electricalCapacity;
    }

    public double getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(double lifeTime) {
        this.lifeTime = lifeTime;
    }

    public double getFirstLoad() {
        return firstLoad;
    }

    public void setFirstLoad(double firstLoad) {
        this.firstLoad = firstLoad;
    }
}
