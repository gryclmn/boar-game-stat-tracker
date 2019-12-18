package com.promineotech.gameStatTracker.requests;

import com.promineotech.gameStatTracker.view.PlayerResult;

import java.util.Date;
import java.util.Set;

public class PlayerGameRequest {

    private Date datePlayed;
    private Long gameId;
    private Set<PlayerResult> playerResults;

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

}
