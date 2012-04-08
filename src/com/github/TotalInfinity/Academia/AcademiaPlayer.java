package com.github.TotalInfinity.Academia;

/**
 * 
 * @author Ryan
 * Class for storing player information for use in the Academia
 * plugin. Implements the serializable interface for storage.
 */
import java.io.Serializable;
import org.bukkit.entity.Player;

public class AcademiaPlayer implements Serializable{
    
    String playerName = "";
    AcademiaClass playerClass = null;
    long currentPlayerExp = 0;
    
    public AcademiaPlayer(Player pl) {
        playerName = pl.getPlayerListName();
    }
    
    public String getPlayerName() {
        return playerName;
    }
    
    public AcademiaClass getAcademiaClass() {
        return playerClass;
    }
    
    public long getPlayerExp() {
        return currentPlayerExp = 0;
    }
    
}