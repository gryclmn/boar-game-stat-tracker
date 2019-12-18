package com.promineotech.gameStatTracker.view;

import com.promineotech.gameStatTracker.entity.Game;
import com.promineotech.gameStatTracker.entity.Player;

import java.util.Set;

public class PlayerHistory {

    private Player player;
    private Set<Game> games;
    private Integer wins;
    private Integer losses;

    public PlayerHistory() {
        this.wins = 0;
        this.losses = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }
}
