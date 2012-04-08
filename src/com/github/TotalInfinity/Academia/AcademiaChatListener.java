
package com.github.TotalInfinity.Academia;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Ryan
 */
public class AcademiaChatListener implements Listener{
    public AcademiaChatListener(JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @EventHandler
    public void login(PlayerChatEvent event) {
        
    }
}
