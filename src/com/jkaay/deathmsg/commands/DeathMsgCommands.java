package com.jkaay.deathmsg.commands;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class DeathMsgCommands implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("setkills")) {
			Player p = Bukkit.getServer().getPlayer(args[0]);
			if (args.length != 2) {
				sender.sendMessage(ChatColor.RED + "Usage: /setkills <player> <amount>");
			} else if (args.length == 2) {
				try {
					try {
						p.setStatistic(Statistic.PLAYER_KILLS, Integer.parseInt(args[1]));
						sender.sendMessage(ChatColor.GREEN + args[0] + "\'s Kills successfully updated to " + ChatColor.YELLOW + args[1]);
					}
					catch (Exception ex) {
						sender.sendMessage(ChatColor.RED + "Error: " + args[0] + " seems to be offline or doesn\'t exist (Or you didn\'t use a number for the amount of kills)");
					}
				}
				catch (Exception ex) {
					sender.sendMessage(ChatColor.RED + "Error: Please use a number for the amount of kills!");	
				}
			}
		} else if (commandLabel.equalsIgnoreCase("checkkills")) {
			if (args.length == 0 || args.length != 1) {
				sender.sendMessage(ChatColor.RED + "Usage: /checkkills <player>");
			} else {
				try {
					sender.sendMessage(ChatColor.AQUA + args[0] + " has " + ChatColor.YELLOW + Bukkit.getServer().getPlayer(args[0]).getStatistic(Statistic.PLAYER_KILLS) + ChatColor.AQUA + " kills.");
				}
				catch (Exception ex) {
					sender.sendMessage(ChatColor.RED + "Error: " + args[0] + " seems to be offline or doesn\'t exist");
				}
			}
		} else if (commandLabel.equalsIgnoreCase("resetkills")) {
			if (args.length != 1) {
				sender.sendMessage(ChatColor.RED + "Usage: /resetkills <player>");
			} else {
				if (args.length == 1) {
					try {
						Bukkit.getServer().getPlayer(args[0]).setStatistic(Statistic.PLAYER_KILLS, 0);
						sender.sendMessage(ChatColor.GREEN + "Successfully reset " + ChatColor.YELLOW + args[0] + "\'s kills.");
					}
					catch (Exception ex) {
						sender.sendMessage(ChatColor.RED + "Error: " + args[0] + " seems to be offline or doesn\'t exist");
					}
				} else {
					sender.sendMessage(ChatColor.RED + "Usage: /resetkills <player> (Just /resetkills to reset all kills)");
				}
			}
		}
		return true;
	}
}
