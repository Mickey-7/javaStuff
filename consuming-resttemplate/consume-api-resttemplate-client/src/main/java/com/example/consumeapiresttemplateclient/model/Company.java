package com.example.consumeapiresttemplateclient.model;

public class Company {
    private Integer id;
    private String companyName;
    private String ceoName;
    private Integer noEmp;

    public Company() {
    }

    public Company(Integer id, String companyName, String ceoName, Integer noEmp) {
        this.id = id;
        this.companyName = companyName;
        this.ceoName = ceoName;
        this.noEmp = noEmp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCeoName() {
        return ceoName;
    }

    public void setCeoName(String ceoName) {
        this.ceoName = ceoName;
    }

    public Integer getNoEmp() {
        return noEmp;
    }

    public void setNoEmp(Integer noEmp) {
        this.noEmp = noEmp;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", ceoName='" + ceoName + '\'' +
                ", noEmp=" + noEmp +
                '}';
    }
}
