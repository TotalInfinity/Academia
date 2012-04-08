package com.github.TotalInfinity.Academia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.bukkit.plugin.java.JavaPlugin;

public class AcademiaConfigLoader {
    JavaPlugin plugin = null;
    File playerInfo = null;
    
    public AcademiaConfigLoader(JavaPlugin pl) {
        plugin = pl;
        plugin.getConfig().addDefault("General.Enabled", true);
        plugin.getConfig().addDefault("General.DisplayNotifications", true);
        plugin.getConfig().addDefault("Vault.UseAcademiaCurrency", true);
        plugin.getConfig().addDefault("Vault.UseAcademiaPermissions", true);
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        playerInfo = new File(plugin.getDataFolder(), "IMPORTANT.txt");
    }
    
    public boolean AcademiaPlayerLoader() {
        if (!playerInfo.isFile()) {
            try {
             playerInfo.createNewFile();
             if(playerInfo.canExecute() && playerInfo.canRead() && playerInfo.canWrite()) {
                 AcademiaDefaultDataWrite();
             }
             else {
                 Academia.log.info("[SEVERE][Academia] Application does not have correct permissions? Plugin disabled.");
                 plugin.getServer().getPluginManager().disablePlugin(plugin);
             }
             return true;
            }
            catch (Exception e) {}
        }
        return false;
    }
    
    public boolean AcademiaDefaultDataWrite() {
        try {
            BufferedWriter fileWrite = new BufferedWriter(new FileWriter(playerInfo));
            fileWrite.write("#Please DO NOT modify any of the files in this directory with the .bin extension. Doing so may corrupt player data and other information and break the plugin");
            fileWrite.close();
            return true;
        }
        catch (Exception e)    {    }
        return false;
    }
}