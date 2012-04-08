package com.github.TotalInfinity.Academia;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
     
public class AcademiaLoginListener implements Listener{
    
    JavaPlugin plugin = null;
    public AcademiaLoginListener(JavaPlugin pl){
        plugin = pl;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void login(PlayerLoginEvent event) {
        Academia.log.info("PLAYER LOGGED IN");
        Academia.log.info(plugin.getConfig().getString("General.DisplayNotifications"));
        if (plugin.getConfig().getBoolean("General.DisplayNotifications", true)) {
            Academia.log.info("SEND THIS PLAYER A MESSAGE DAMMIT");
            event.getPlayer().sendRawMessage("Welcome, " + event.getPlayer().getPlayerListName() + "!");
        }
        /*
         * Check if player is registered, if not, create player info for that player
         */
        if(!Academia.playerMap.containsKey(event.getPlayer())) {
            Academia.playerMap.put(event.getPlayer(), new AcademiaPlayer(event.getPlayer()));
            event.getPlayer().sendMessage("We notice this is your first time playing using Academia.");
            event.getPlayer().sendMessage("If you need any help, type the command /beginner for a brief intro.");
        }
    }
    
    @EventHandler
    public void logout(PlayerQuitEvent event) {
        
    }
}