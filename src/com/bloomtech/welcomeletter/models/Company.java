package com.bloomtech.welcomeletter.models;

public class Company {
    private static int maxId = 1;
    private int id;

    private String companyname;
    private String country;

    //TODO: Replace with Builder Constructor
    public Company(String companyname, String country) {
        //Auto-generate an id
        id = maxId;
        maxId++;

        //Initialize fields
        this.companyname = companyname;
        this.country = country;
    }

    public static final class Builder {
        //TODO: Implement Builder Pattern
    }

    public int getId() {
        return id;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getCountry() {
        return country;
    }
}
