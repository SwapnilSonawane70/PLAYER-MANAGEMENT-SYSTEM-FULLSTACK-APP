package com.player_manager.Player_Managenet.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player_manager.Player_Managenet.Entity.Player;
import com.player_manager.Player_Managenet.Exception.ResourceNotFoundException; // Corrected exception class name
import com.player_manager.Player_Managenet.Repository.PlayerRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    
    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }
    
    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not exists with id " + id));
        
        return ResponseEntity.ok(player);
    }
    @PutMapping("/players/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @RequestBody Player playerDetails) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not exists with id " + id));
        
        player.setName(playerDetails.getName());
        player.setStatus(playerDetails.getStatus());
        player.setRuns(playerDetails.getRuns());
        player.setWickets(playerDetails.getWickets());       
        Player updatedPlayer = playerRepository.save(player);
        return ResponseEntity.ok(updatedPlayer);
    }
    @DeleteMapping("/players/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePlayer(@PathVariable int id){
    	
    	 Player player = playerRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Player not exists with id " + id));
    	 
    	 playerRepository.delete(player);
    	 Map<String,Boolean>response=new HashMap<String,Boolean>();
    	 response.put("delete", Boolean.TRUE);
    	 return ResponseEntity.ok(response);
    	
    }

}
