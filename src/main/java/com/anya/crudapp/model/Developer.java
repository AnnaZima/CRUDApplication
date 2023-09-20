package com.anya.crudapp.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "developers_skills",
            joinColumns = { @JoinColumn(name = "developers_id") },
            inverseJoinColumns = { @JoinColumn(name = "skills_id") })
    private List<Skill> skills;
    @ManyToOne()
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    @Enumerated(EnumType.STRING)
    @Column (name = "status")
    private Status status;

    public Developer(String firstname, String lastname, List<Skill> skills, Specialty specialty, Status status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.skills = skills;
        this.specialty = specialty;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", skills=" + skills.stream().map(Skill::getName).toList() +
                ", specialty=" + specialty +
                ", status=" + status +
                '}';
    }
}
