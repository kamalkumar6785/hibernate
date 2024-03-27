package org.example.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String genre;

    @ManyToMany(mappedBy = "actor")
    private List<Actor> Actor;

    public List<Actor> getActor() {
        return Actor;
    }

    public void setActor(List<Actor> actor) {
        Actor = actor;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String toString() {
        StringBuilder res = new StringBuilder("Movie{" +
                "id=" + id +
                ", Name'" + name + '\'' +
                ", Genre='" + genre + '\'' +
                ", actor=");

        for(Actor s : getActor()){
            res.append(s.getfName()).append(" ").append(s.getlName()).append(", ");
        }

        res.append("}");

        return res.toString();
    }

}
