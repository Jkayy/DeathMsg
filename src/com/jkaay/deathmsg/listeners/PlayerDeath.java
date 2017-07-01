package com.jkaay.deathmsg.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.jkaay.deathmsg.Main;

public class PlayerDeath implements Listener {
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerDeath(PlayerDeathEvent e) {
		String player = e.getEntity().getName().toString();
		Player p = Bukkit.getServer().getPlayer(player);
		Player killer = e.getEntity().getKiller();
		if (p.getLastDamageCause().getCause() == DamageCause.FALL) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "fell from a high place")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK) {
			if (p.isDead()) {
				if (killer.getStatistic(Statistic.PLAYER_KILLS) == 0) {
					killer.setStatistic(Statistic.PLAYER_KILLS, 1);
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_by_killer").replaceAll("%victim%", p.getName())
							.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%killer%", killer.getName()).replaceAll("%killerkills%", Integer.toString(killer.getStatistic(Statistic.PLAYER_KILLS)))));
				} else {
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_by_killer").replaceAll("%victim%", p.getName())
							.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%killer%", killer.getName()).replaceAll("%killerkills%", Integer.toString(killer.getStatistic(Statistic.PLAYER_KILLS)))));
				}
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.LAVA) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "tried to swim in lava")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.FIRE) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "went up in flames")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.LIGHTNING) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "was struck by lightning")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.CONTACT) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "was pricked to death")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.BLOCK_EXPLOSION) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "blew up")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.DROWNING) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "drowned")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.FIRE_TICK) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "burned to death")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.FALLING_BLOCK) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "was squashed by a falling block")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.MAGIC) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "was killed by magic")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.STARVATION) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "starved to death")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.SUFFOCATION) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "suffocated in a wall")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.POISON) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "was poisoned to death")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.PROJECTILE) {
			if (p.isDead()) {
				if (p.getKiller() instanceof Player) {
					String killerkills = Integer.toString(killer.getStatistic(Statistic.PLAYER_KILLS));
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
							.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "was shot by " + killer.getName() + ChatColor.DARK_GRAY + "[" + 
					ChatColor.GREEN + killerkills + ChatColor.DARK_GRAY + "]")));
				} else {
					Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
							.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "was shot by skeleton")));
				}
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.VOID) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "fell out of the world")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.WITHER) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "withered away")));
			}
		} else if (p.getLastDamageCause().getCause() == DamageCause.SUICIDE) {
			if (p.isDead()) {
				Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("death_message_without_killer").replaceAll("%victim%", p.getName())
						.replaceAll("%victimkills%", Integer.toString(p.getStatistic(Statistic.PLAYER_KILLS))).replaceAll("%cause%", "took their own life")));
			}
		}
	}
}
