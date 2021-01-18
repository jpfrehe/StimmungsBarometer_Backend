package de.fiduciagad.backend.user;

import javax.persistence.*;

@Entity(name = "user")
@Table
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String userKennung;
    private String vorname;
    private String nachname;


    private User(){

    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getUserKennung() {
        return userKennung;
    }

    public void setUserKennung(String userKennung) {
        this.userKennung = userKennung;
    }

    public User(String userKennung, String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.userKennung = userKennung;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
