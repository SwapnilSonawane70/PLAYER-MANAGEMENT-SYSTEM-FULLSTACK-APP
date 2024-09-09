package com.player_manager.Player_Managenet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.player_manager.Player_Managenet.Entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
