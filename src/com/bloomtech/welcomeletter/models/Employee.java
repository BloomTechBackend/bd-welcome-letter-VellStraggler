package com.bloomtech.welcomeletter.models;

import java.time.LocalDate;

public class Employee {
    private static int maxId = 1;

    private int id;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    private int salary;
    private LocalDate startdate;
    private Role role;
    private Company company;

    //TODO: Implement Builder Pattern

    //TODO: Replace with Builder Constructor
    public Employee(String firstname, String lastname, String phonenumber, String email, int salary, LocalDate startdate, Role role, Company company) {
        //Auto-generate an id
        id = maxId;
        maxId++;

        //TODO: Initialize fields:
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.salary = salary;
        this.startdate = startdate;
        this.role = role;
        this.company = company;
    }

    //TODO: Create Builder Class
    public static final class Builder {
        private String firstname;
        private String lastname;
        private String phonenumber;
        private String email;
        private int salary;
        private LocalDate startdate;
        private Role role;
        private Company company;

        public Builder withFirstname(String name) {
            firstname = name;
            return this;
        }
        public Builder withLastname(String name) {
            lastname = name;
            return this;
        }
        public Builder withPhonenumber(String number) {
            phonenumber = number;
            return this;
        }
        public Builder withStartdate(LocalDate date) {
            startdate = date;
            return this;
        }
        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder withSalary(int salary) {
            this.salary = salary;
            return this;
        }
        public Builder withRole(Role role) {
            this.role = role;
            return this;
        }
        public Builder withCompany(Company company) {
            this.company = company;
            return this;
        }
        public Employee build() {
            if (firstname == null || company == null) {
                throw new RuntimeException("Employee must have a first name and a company.");
            }
            return new Employee(firstname, lastname, phonenumber, email, salary, startdate, role, company);
        }
    }
    public static Builder builder() {
        return new Builder();
    }

    //Getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public Role getRole() {
        return role;
    }

    public Company getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }
}
