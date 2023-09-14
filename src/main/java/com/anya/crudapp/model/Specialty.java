package com.anya.crudapp.model;

public class Specialty {

    int id;
    String name;

    public Specialty(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Specialty() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
