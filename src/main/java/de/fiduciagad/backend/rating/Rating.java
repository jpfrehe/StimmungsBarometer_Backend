package de.fiduciagad.backend.rating;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Rating")
@Table
public class Rating {
    @JsonIgnore
    @Id
    @SequenceGenerator(name = "rating_sequence", sequenceName = "rating_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_sequence")
    private Long id_rating;


    private LocalDate dateOfRating = LocalDate.now();
    private String mitgliedName;
    private String teamName;
    private int stimmung;
    private int coffeeCount;
    private Long teamid;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTeamid() {
        return teamid;
    }

    public void setTeamid(Long teamid) {
        this.teamid = teamid;
    }

    public Rating() {

    }

    public Rating(String mitgliedName, String teamName, int stimmung, int coffeeCount) {
        this.mitgliedName = mitgliedName;
        this.teamName = teamName;
        this.stimmung = stimmung;
        this.coffeeCount = coffeeCount;

    }

    public Long getId_rating() {
        return id_rating;
    }

    public LocalDate getDateOfRating() {
        return dateOfRating;
    }

    public void setDateOfRating(LocalDate dateOfRating) {
        this.dateOfRating = dateOfRating;
    }

    public void setId_rating(Long id_rating) {
        this.id_rating = id_rating;
    }

    public String getMitgliedName() {
        return mitgliedName;
    }

    public void setMitgliedName(String mitgliedName) {
        this.mitgliedName = mitgliedName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getStimmung() {
        return stimmung;
    }

    public void setStimmung(int stimmung) {
        this.stimmung = stimmung;
    }

    public int getCoffeeCount() {
        return coffeeCount;
    }

    public void setCoffeeCount(int coffeeCount) {
        this.coffeeCount = coffeeCount;
    }
}
