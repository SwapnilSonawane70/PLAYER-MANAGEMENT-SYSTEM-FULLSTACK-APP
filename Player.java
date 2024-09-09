package com.player_manager.Player_Managenet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jerseyno; 

    @Column(name = "name")
    private String name;

    @Column(name ="player_status")
    private String status;

    private Integer runs; 

    private Integer wickets; 

    //@Column(name ="played_matches")
    private Integer playedmatches; 
    
    // Default constructor
    public Player() {
    }

    // Parameterized constructor
    public Player(Integer jerseyno, String name, String status, Integer runs, Integer wickets, Integer playedmatches) {
        this.jerseyno = jerseyno;
        this.name = name;
        this.status = status;
        this.runs = runs;
        this.wickets = wickets;
        this.playedmatches = playedmatches;
    }

    // Getters and setters
    public Integer getJerseyno() {
        return jerseyno;
    }

    public void setJerseyno(Integer jerseyno) {
        this.jerseyno = jerseyno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public Integer getPlayedmatches() {
        return playedmatches;
    }

    public void setPlayedmatches(Integer playedmatches) {
        this.playedmatches = playedmatches;
    }
}
