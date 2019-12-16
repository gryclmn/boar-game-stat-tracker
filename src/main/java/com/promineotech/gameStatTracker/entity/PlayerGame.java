package com.promineotech.gameStatTracker.entity;

import com.promineotech.gameStatTracker.service.GameService;
import com.promineotech.gameStatTracker.service.PlayerService;
import javax.persistence.*;
import java.util.Date;

@Entity
public class PlayerGame {

    private Long id;
    private Date datePlayed;
    private Game game;
    private Player player;
//    private Long gameId;
//    private Long playerId;
    private Boolean playerWon;
    private Integer playerRank;
    private Double playerPoints;

    private GameService gameService = new GameService();
    private PlayerService playerService = new PlayerService();

    public PlayerGame(
            Date datePlayed,
            Game game,
            Player player,
            Boolean playerWon,
            Integer playerRank,
            Double playerPoints
    ) {
        this.datePlayed = datePlayed;
        this.game = game;
        this.player = player;
        this.playerWon = playerWon;
        this.playerRank = playerRank;
        this.playerPoints = playerPoints;
    }

    public PlayerGame() {}

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

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "game_id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "player_id")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

//    @ManyToOne
//    @JoinColumn(name = "game_id")
//    public Long getGameId() {
//        return gameId;
//    }
//
//    public void setGameId(Long gameId) {
//        this.gameId = gameId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "player_id")
//    public Long getPlayerId() {
//        return playerId;
//    }
//
//    public void setPlayerId(Long playerId) {
//        this.playerId = playerId;
//    }

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
