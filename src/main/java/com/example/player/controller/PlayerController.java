/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 */

// Write your code here
package com.example.player.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class PlayerController{
    @Autowired 
    private PlayerJpaService playerservice;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers(){
        return playerservice.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId){
        return playerservice.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerservice.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId,@RequestBody Player player){
        return playerservice.updatePlayer(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        playerservice.deletePlayer(playerId);
    }
}