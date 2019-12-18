package com.promineotech.gameStatTracker.controller;

import com.promineotech.gameStatTracker.entity.Player;
import com.promineotech.gameStatTracker.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getPlayer(@PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.getPlayerById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Object> getCustomers() {
        return new ResponseEntity<Object>(service.getPlayers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createPlayer(@RequestBody Player player) {
        return new ResponseEntity<Object>(service.createPlayer(player), HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Object> updatePlayer(@RequestBody Player player, @PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.updatePlayer(player, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}/history", method = RequestMethod.GET)
    public ResponseEntity<Object> getPlayerHistory(@PathVariable Long id) {
        try {
            return new ResponseEntity<Object>(service.getPlayerHistoryById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
