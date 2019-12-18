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

    // TODO - this is not working because HTTP has playerId and gameId instead of player and game objects
    // May need to use a PlayerGameRequest here just like createPlayerGame() above?

    public PlayerGame updatePlayerGame(PlayerGameRequest playerGameRequest, Long id) throws Exception {
        try {
            PlayerResult result = playerGameRequest.getPlayerResults().iterator().next();
            PlayerGame oldPlayerGame = repo.findOne(id);
            oldPlayerGame.setDatePlayed(playerGameRequest.getDatePlayed());
            oldPlayerGame.setGame(
                gameService.getGameById(playerGameRequest.getGameId())
            );
            oldPlayerGame.setPlayer(
                playerService.getPlayerById(result.getPlayerId())
            );
            oldPlayerGame.setPlayerWon(result.getIsWinner());
            oldPlayerGame.setPlayerRank(result.getRank());
            oldPlayerGame.setPlayerPoints(result.getPoints());
            return repo.save(oldPlayerGame);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to update a PlayerGame: " + id, e);
            throw new Exception("Unable to update PlayerGame.");
        }
    }

//    public PlayerGame updatePlayerGame(PlayerGame playerGame, Long id) throws Exception {
//        try {
//            PlayerGame oldPlayerGame = repo.findOne(id);
//            oldPlayerGame.setDatePlayed(playerGame.getDatePlayed());
//            oldPlayerGame.setGame(playerGame.getGame());
//            oldPlayerGame.setPlayer(playerGame.getPlayer());
//            oldPlayerGame.setPlayerWon(playerGame.getPlayerWon());
//            oldPlayerGame.setPlayerRank(playerGame.getPlayerRank());
//            oldPlayerGame.setPlayerPoints(playerGame.getPlayerPoints());
//            return repo.save(oldPlayerGame);
//        } catch (Exception e) {
//            logger.error("Exception occurred while trying to update a PlayerGame: " + id, e);
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
