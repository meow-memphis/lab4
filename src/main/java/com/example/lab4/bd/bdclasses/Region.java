package com.example.lab4.bd.bdclasses;

public class Region {

    int id;
    String name;
    int col;

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = this.col + col;
    }

    private double consumption;

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = this.consumption + consumption;
    }

    public Region(int id, String name) {
        this.id = id;
        this.name = name;
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
}
