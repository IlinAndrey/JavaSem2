package com.example.task14.models;

public class Address {
    private int zip_id;
    private String name;
    private String addressText;
    private int zipCode;

    public Address(String name, String addressText, int zipCode) {
        this.name = name;
        this.addressText = addressText;
        this.zipCode = zipCode;
    }

    public int getId() {
        return zip_id;
    }

    public void setId(int id) {
        this.zip_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + zip_id +
                ", name='" + name + '\'' +
                ", creationDate='" + addressText + '\'' +
                ", price=" + zipCode +
                '}';
    }
}
