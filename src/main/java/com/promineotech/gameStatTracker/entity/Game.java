package com.promineotech.gameStatTracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Game {

    private Long id;
    private String name;

    @JsonIgnore
    private Set<PlayerGame> playerGames;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "player")
    public Set<PlayerGame> getPlayerGames() {
        return playerGames;
    }

    public void setPlayerGames(Set<PlayerGame> playerGames) {
        this.playerGames = playerGames;
    }


}
