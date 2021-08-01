package de.timeox2k;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.timeox2k.listener.PlayerJoinListener;
import de.timeox2k.listener.PlayerMoveListener;
import de.timeox2k.utils.Color;

public class LightRacers extends JavaPlugin {

	private static LightRacers instance;
	private HashMap<Player, Color> playerColor;

	@Override
	public void onEnable() {
		PluginManager pluginManager = getServer().getPluginManager();
		playerColor = new HashMap<>();
		instance = this;

		pluginManager.registerEvents(new PlayerJoinListener(), this);
		pluginManager.registerEvents(new PlayerMoveListener(), this);

		getConfig().addDefault("Settings.BoostVelocity", 0.5);
		getConfig().options().copyDefaults(true);
		saveConfig();

		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player player : Bukkit.getOnlinePlayers()) {
					Vector vector = new Vector(player.getLocation().getDirection().getX(), player.getVelocity().getY(),
							player.getLocation().getDirection().getZ());
					vector = vector.normalize();
					player.setVelocity(vector.multiply(getConfig().getDouble("Settings.BoostVelocity")));
				}
			}
		}.runTaskTimer(getInstance(), 5, 5);
	}

	public Location getBlockBehindPlayer(Player player) {
		
		Vector inverseVec = player.getLocation().getDirection().normalize().multiply(-1);
		Location location = player.getLocation().add(inverseVec);
		
		location.setY(player.getLocation().getY());
		return location;
	}

	@Override
	public void onDisable() {
		for (Player all : Bukkit.getOnlinePlayers()) {
			all.kickPlayer("Dieser Server startet neu!");
		}

	}

	public HashMap<Player, Color> getPlayerColor() {
		return playerColor;
	}

	public static LightRacers getInstance() {
		return instance;
	}

}
