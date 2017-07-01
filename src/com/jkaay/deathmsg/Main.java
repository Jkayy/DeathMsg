package com.jkaay.deathmsg;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.jkaay.deathmsg.commands.DeathMsgCommands;
import com.jkaay.deathmsg.listeners.PlayerDeath;

public class Main extends JavaPlugin {
	
    private static Main instance;
    
    public void onEnable() {
    	instance = this;
    	getLogger().info("--- DeathMsg Has been Enabled Successfully ---");
    	PluginManager pm = Bukkit.getPluginManager();
    	pm.registerEvents(new PlayerDeath(), this);
    	registerCommands();
    	getConfig();
    	getConfig().addDefault("death_message_by_killer", "&c%victim%&8[&a%victimkills%&8] &ewas slain by &c%killer%&8[&a%killerkills%&8]");
    	getConfig().addDefault("death_message_without_killer", "&c%victim%&8[&a%victimkills%&8] &e%cause%");
    	saveDefaultConfig();
    }
    
    public void onDisable() {
    	getLogger().info("--- DeathMsg Has been Disabled ---");
    	instance = null;
    }
    
    private void registerCommands() {
    	getCommand("setkills").setExecutor(new DeathMsgCommands());
    	getCommand("checkkills").setExecutor(new DeathMsgCommands());
    	getCommand("resetkills").setExecutor(new DeathMsgCommands());
    }
    
    public static Main getInstance() {
    	return instance;
    }
}
