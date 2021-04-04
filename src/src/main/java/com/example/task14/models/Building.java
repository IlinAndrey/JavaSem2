package com.example.task14.models;

public class Building {
    private int type;
    private String creationDate;

    public Building() {
    }

    public Building(String orderDate) {
        this.creationDate = orderDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Building{" +
                "type=" + type +
                ", creationDate='" + creationDate + '\'' +
                '}';
    }
}
