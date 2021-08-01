package de.timeox2k.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.timeox2k.LightRacers;
import de.timeox2k.utils.Color;

public class PlayerMoveListener implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
				
		Location location = LightRacers.getInstance().getBlockBehindPlayer(player);
		Color color = LightRacers.getInstance().getPlayerColor().get(player);

		if(location.getBlock().getType() != Material.AIR) return;
		
		switch (color) {
		case RED:
			player.getWorld().getBlockAt(location).setType(Material.STAINED_GLASS_PANE);
			player.getWorld().getBlockAt(location).setData((byte) 14);

			break;

		case GREEN:
			player.getWorld().getBlockAt(location).setType(Material.STAINED_GLASS_PANE);
			player.getWorld().getBlockAt(location).setData((byte) 5);

			break;

		case BLUE:
			player.getWorld().getBlockAt(location).setType(Material.STAINED_GLASS_PANE);
			player.getWorld().getBlockAt(location).setData((byte) 3);
			player.sendBlockChange(location, Material.STAINED_GLASS_PANE.getId(), (byte) 3);
			break;

		case YELLOW:
			player.getWorld().getBlockAt(location).setType(Material.STAINED_GLASS_PANE);
			player.getWorld().getBlockAt(location).setData((byte) 4);
			player.sendBlockChange(location, Material.STAINED_GLASS_PANE.getId(), (byte) 4);
			break;

		case ORANGE:
			player.getWorld().getBlockAt(location).setType(Material.STAINED_GLASS_PANE);
			player.getWorld().getBlockAt(location).setData((byte) 1);
			player.sendBlockChange(location, Material.STAINED_GLASS_PANE.getId(), (byte) 1);
			break;

		case PURPLE:
			player.getWorld().getBlockAt(location).setType(Material.STAINED_GLASS_PANE);
			player.getWorld().getBlockAt(location).setData((byte) 2);
			player.sendBlockChange(location, Material.STAINED_GLASS_PANE.getId(), (byte) 2);
			break;

		case PINK:
			player.getWorld().getBlockAt(location).setType(Material.STAINED_GLASS_PANE);
			player.getWorld().getBlockAt(location).setData((byte) 6);
			player.sendBlockChange(location, Material.STAINED_GLASS_PANE.getId(), (byte) 6);
			break;

		default:
			player.getWorld().getBlockAt(location).setType(Material.STAINED_GLASS_PANE);
			player.getWorld().getBlockAt(location).setData((byte) 14);
			player.sendBlockChange(location, Material.STAINED_GLASS_PANE.getId(), (byte) 14);
			break;
		}
	}

}
