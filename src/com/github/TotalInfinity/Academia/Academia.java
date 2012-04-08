package com.github.TotalInfinity.Academia;

// Java Imports
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The main class for the Academia plugin. Loads and initializes the player
 * database, as well as calling the main listeners.
 * @author TotalInfinity
 */
public class Academia extends JavaPlugin{
    
    /**
     * The main method in java, does nothing in Bukkit.
     */
    
    public static void main(String[] args) {
        // Nothing!
    }
    
    private AcademiaLoginListener loginListener = null;
    private AcademiaChatListener chatListener = null;
    private AcademiaConfigLoader configLoader = null;
    public static Map<Player, AcademiaPlayer> playerMap = new HashMap<>();
    static final Logger log = Logger.getLogger("Minecraft");
    
    /**
     * Loads listeners and assets on plugin load.
     */
    
    @Override
    public void onEnable() {
        loginListener = new AcademiaLoginListener(this);
        chatListener = new AcademiaChatListener(this);
        configLoader = new AcademiaConfigLoader(this);
        configLoader.AcademiaPlayerLoader();
        if (!getConfig().getBoolean("General.Enabled")) {
            log.info("Academia (CB 1.2.5) turned off in config, will be disabled");
            getServer().getPluginManager().disablePlugin(this);
        }
        else {
            try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.getDataFolder().toString() + "\\data.bin"));
            playerMap = (Map)ois.readObject();
            ois.close();
            }
            catch (Exception e) {}
            log.info("Academia (CB 1.2.5-R1) has been enabled successfully!");
        }
    }
    
    /**
     * Unloads any loaded assets on plugin disable (server shutdown)
     */
    
    @Override
    public void onDisable() {
        try {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.getDataFolder().toString() + "\\data.bin"));
        oos.writeObject(playerMap);
        oos.flush();
        oos.close();
        }
        catch (Exception e) {}
        log.info("Academia (CB 1.2.5-R1) has been disabled successfully!");
    }
}