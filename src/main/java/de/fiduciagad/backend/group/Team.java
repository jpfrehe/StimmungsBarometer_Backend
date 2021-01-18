package de.fiduciagad.backend.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.fiduciagad.backend.rating.Rating;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Team")
@Table
public class Team {
    @Id
    @SequenceGenerator(name = "team_sequence", sequenceName = "team_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_sequence")
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name="teamid", referencedColumnName = "id")
    private List<Rating> ratings;

    public Team(String name) {
        this.name = name;
    }
    public Team(){

    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
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
