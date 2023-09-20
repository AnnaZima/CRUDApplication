package com.anya.crudapp.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "developers_skills",
            joinColumns = { @JoinColumn(name = "skills_id") },
            inverseJoinColumns = { @JoinColumn(name = "developers_id") })
    private List<Developer> developers;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers=" + developers.stream().map(Developer::getId).toList() +
                ", status=" + status +
                '}';
    }
}
