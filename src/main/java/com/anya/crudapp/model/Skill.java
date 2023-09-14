package com.anya.crudapp.model;

import jakarta.persistence.ManyToMany;

import java.util.List;

public class Skill {
    int id;
    String name;
    @ManyToMany(mappedBy = "skills")
    List<Developer> developers;

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

      public Skill() {
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


    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers=" + developers +
                '}';
    }
}
