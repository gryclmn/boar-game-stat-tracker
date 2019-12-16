package com.promineotech.gameStatTracker.service;

import com.promineotech.gameStatTracker.entity.Game;
import com.promineotech.gameStatTracker.repository.GameRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private static final Logger logger = LogManager.getLogger(GameService.class);

    @Autowired
    private GameRepository repo;

    public Game getGameById(Long id) {
        try {
            return repo.findOne(id);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to retrieve game: " + id, e);
            throw e;
        }
    }

    public Iterable<Game> getGames() {
        return repo.findAll();
    }

    public Game createGame(Game game) {
        return repo.save(game);
    }

    public Game updateGame(Game game, Long id) throws Exception {
        try {
            Game oldGame = repo.findOne(id);
            oldGame.setName(game.getName());
            return repo.save(oldGame);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to udpate a game: " + id, e);
            throw new Exception("Unable to update game.");
        }
    }

    public void deleteGame(Long id) throws Exception {
        try {
            repo.delete(id);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to delete game: " + id, e);
            throw new Exception("Unable to delete game.");
        }
    }

}
