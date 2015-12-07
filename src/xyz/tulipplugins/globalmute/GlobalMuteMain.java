package xyz.tulipplugins.globalmute;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.tulipplugins.globalmute.events.GlobalMuteEvents;

public class GlobalMuteMain extends JavaPlugin {
	
	public void onEnable(){
		
		registerEvents();
		registerCommands();
		saveDefaultConfig();
	}
	
	
	public void registerEvents(){
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new GlobalMuteEvents(), this);
		
	}
	public void registerCommands(){
		
		getCommand("globalmute").setExecutor(new GlobalMuteEvents());
		
	}
	public void registerConfig(String playernochatmessage){
		playernochatmessage = getConfig().getString("playernochatmessage");
		
		
	}
	
	
	

}
