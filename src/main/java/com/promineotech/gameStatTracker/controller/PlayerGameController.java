package com.promineotech.gameStatTracker.controller;

import com.promineotech.gameStatTracker.entity.Game;
import com.promineotech.gameStatTracker.entity.PlayerGame;
import com.promineotech.gameStatTracker.requests.PlayerGameRequest;
import com.promineotech.gameStatTracker.service.PlayerGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playergame")
public class PlayerGameController {

    @Autowired
    private PlayerGameService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Object> getPlayerGame(@PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.getPlayerGameById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<Object> getPlayerGames() {
        return new ResponseEntity<Object>(service.getPlayerGames(), HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Object> createPlayerGame(@RequestBody PlayerGameRequest playerGameRequest) {
        return new ResponseEntity<Object>(service.createPlayerGame(playerGameRequest), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updatePlayerGame(@RequestBody PlayerGameRequest playerGameRequest, @PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.updatePlayerGame(playerGameRequest, id), HttpStatus.OK);
//            return new ResponseEntity<Object>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deletePlayerGame(@PathVariable Long id) {
        try {
            service.deletePlayerGame(id);
            return new ResponseEntity<Object>("Successfully deleted game with id: " + id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
