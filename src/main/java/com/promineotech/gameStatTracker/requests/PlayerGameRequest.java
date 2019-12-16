package com.promineotech.gameStatTracker.requests;

import com.promineotech.gameStatTracker.view.PlayerResult;

import java.util.Date;
import java.util.Set;

public class PlayerGameRequest {

    private Date datePlayed;
    private Long gameId;
    private Set<PlayerResult> playerResults;
    private Long playerId;
    private Boolean playerWon;
    private Integer playerRank;
    private Double playerPoints;

    public Date getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Date datePlayed) {
        this.datePlayed = datePlayed;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Set<PlayerResult> getPlayerResults() {
        return playerResults;
    }

    public void setPlayerResults(Set<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
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
