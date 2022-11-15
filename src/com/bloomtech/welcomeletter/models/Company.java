package com.bloomtech.welcomeletter.models;

public class Company {
    private static int maxId = 1;
    private int id;
    private String companyName;
    private String country;

    public Company(String companyName, String country) {
        //Auto-generate an id
        id = maxId;
        maxId++;

        //Initialize fields
        this.companyName = companyName;
        this.country = country;
    }

    public static final class Builder {
        private String companyName;
        private String country;

        public Builder withCompanyname(String companyName) {
            this.companyName = companyName;
            return this;
        }
        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }
        public Company build() {
            return new Company(companyName, country);
        }
    }
    public static Builder builder() {
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCountry() {
        return country;
    }
}
