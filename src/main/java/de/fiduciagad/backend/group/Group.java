package de.fiduciagad.backend.group;

import javax.persistence.*;

@Entity(name = "group_comp")
@Table
public class Group {
    @Id
    @SequenceGenerator(name = "group_sequence", sequenceName = "group_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_sequence")
    private Long id;
    private String name;

    public Group(String name) {
        this.name = name;
    }
    public Group(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
