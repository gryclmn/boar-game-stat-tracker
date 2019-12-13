package com.promineotech.gameStatTracker.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PlayerGame {

    private Long id;
    private Date datePlayed;
    private Game game;
    private Player player;
    private Boolean playerWon;
    private Integer playerRank;
    private Double playerPoints;

    // TODO: Shouldn't ID be specific to each game SESSION, and not a new ID for each row?
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Date datePlayed) {
        this.datePlayed = datePlayed;
    }

    @ManyToOne
    @JoinColumn(name = "game")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @ManyToOne
    @JoinColumn(name = "player")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Boolean getPlayerWon() {
        return playerWon;
    }

    public void setPlayerWon(Boolean playerWon) {
        this.playerWon = playerWon;
    }

    public Integer getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(Integer playerRank) {
        this.playerRank = playerRank;
    }

    public Double getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(Double playerPoints) {
        this.playerPoints = playerPoints;
    }
}
