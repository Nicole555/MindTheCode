package com.nikosportolos.MtCProject1.models.responses;

import com.nikosportolos.MtCProject1.models.Company;

public class BusinessUnitResponse {

    /**
     * Instance variables
     **/

    private long id;
    private String name;
    private Company company;


    /**
     * Constructors
     **/

    public BusinessUnitResponse() {
    }

    public BusinessUnitResponse(long id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    /**
     * Getters / Setters
     **/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
