package com.mycompany.unipar.central.models;

public abstract class AbstractAcademico {
    private int id;
    private String ra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
}
