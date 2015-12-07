package xyz.tulipplugins.globalmute.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import xyz.tulipplugins.globalmute.GlobalMuteMain;

public class GlobalMuteEvents implements Listener, CommandExecutor {
	String playernochatmessage = "";
	boolean mutedChat;
	

	

	@SuppressWarnings("deprecation")
	
    @EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
	
		Player player = event.getPlayer();

		if (mutedChat == true) {
			

			if (player.hasPermission("globalmute.exempt") || player.isOp()) {
				
				return;
			} else {
				event.setCancelled(true);
				player.sendMessage(ChatColor.GRAY + playernochatmessage);
			}

		}
		if (mutedChat == false) {
			mutedChat = true;
		
			return;

		}

	}

	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {

		Player player = (Player) sender;

		if (command.getName().equalsIgnoreCase("globalmute")) {
			if (player.hasPermission("globalmute.globalmute")) {
				if (mutedChat != true) {
					mutedChat = true;
					player.sendMessage(ChatColor.DARK_GRAY + "Global chat muted.");

				}else{
					mutedChat = false;
					player.sendMessage(ChatColor.DARK_GRAY + "Global chat reenabled");
				}
				
			}
		}

		return false;
	}
	
	public void passConfig(){
		
		
		GlobalMuteMain configObject = new GlobalMuteMain();
		configObject.registerConfig(playernochatmessage);
		
	}
}
