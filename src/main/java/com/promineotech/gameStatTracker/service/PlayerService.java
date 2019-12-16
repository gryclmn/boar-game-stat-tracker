package com.promineotech.gameStatTracker.service;

import com.promineotech.gameStatTracker.entity.Player;
import com.promineotech.gameStatTracker.repository.PlayerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private static final Logger logger = LogManager.getLogger(PlayerService.class);

    @Autowired
    private PlayerRepository repo;

    public Player getPlayerById(Long id) {
        try {
            return repo.findOne(id);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to retrieve player: " + id, e);
            throw e;
        }
    }

    public Iterable<Player> getPlayers() {
        return repo.findAll();
    }

    public Player createPlayer(Player player) {
        return repo.save(player);
    }

    public Player updatePlayer(Player player, Long id) throws Exception {
        try {
            Player oldPlayer = repo.findOne(id);
            oldPlayer.setFirstName(player.getFirstName());
            oldPlayer.setLastName(player.getLastName());
            return repo.save(oldPlayer);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to udpate player: " + id, e);
            throw new Exception("Unable to update player.");
        }
    }

    public void deletePlayer(Long id) throws Exception {
        try {
            repo.delete(id);
        } catch (Exception e) {
            logger.error("Exception occurred while trying to delete player: " + id, e);
            throw new Exception("Unable to delete player.");
        }
    }

}
