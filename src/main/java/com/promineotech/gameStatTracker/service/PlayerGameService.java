package com.promineotech.gameStatTracker.service;

import com.promineotech.gameStatTracker.entity.PlayerGame;
import com.promineotech.gameStatTracker.repository.PlayerGameRepository;
import com.promineotech.gameStatTracker.requests.PlayerGameRequest;
import com.promineotech.gameStatTracker.view.PlayerResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerGameService {

    private static final Logger logger = LogManager.getLogger(GameService.class);

    @Autowired
    private PlayerGameRepository repo;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    public PlayerGame getPlayerGameById(Long id) throws Exception {
        try {
            return repo.findOne(id);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to retrieve PlayerGame: " + id, e);
            throw e;
        }
    }

    public Iterable<PlayerGame> getPlayerGames() {
        return repo.findAll();
    }

    // TODO return GameSession here? Need new GameSession View?
    public PlayerGame createPlayerGame(PlayerGameRequest playerGameRequest) {
        for (PlayerResult result : playerGameRequest.getPlayerResults()) {

            PlayerGame playerGame = new PlayerGame(
                    playerGameRequest.getDatePlayed(),
                    gameService.getGameById(playerGameRequest.getGameId()),
                    playerService.getPlayerById(result.getPlayerId()),
                    result.getIsWinner(),
                    result.getRank(),
                    result.getPoints()
            );

            repo.save(playerGame);
        }

        return new PlayerGame();
    }


//    private Long id;
//    private Date datePlayed;
//    private Game game;
//    private Player player;
//    private Boolean playerWon;
//    private Integer playerRank;
//    private Double playerPoints;

//    public PlayerGame updatePlayerGame(PlayerGame playerGame, Long id) throws Exception {
//        try {
//            PlayerGame oldPlayerGame = repo.findOne(id);
//            oldPlayerGame.setName(playerGame.getName());
//            return repo.save(oldPlayerGame);
//        } catch (Exception e) {
//            logger.error("Exception occurred while trying to udpate a PlayerGame: " + id, e);
//            throw new Exception("Unable to update PlayerGame.");
//        }
//    }

    public void deletePlayerGame(Long id) throws Exception {
        try {
            repo.delete(id);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to delete PlayerGame: " + id, e);
            throw new Exception("Unable to delete PlayerGame.");
        }
    }

}
