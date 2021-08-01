package de.timeox2k.listener;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.timeox2k.LightRacers;
import de.timeox2k.utils.Color;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 300000, 200, true));
		switch (new Random().nextInt(6)) {
		case 0:
			LightRacers.getInstance().getPlayerColor().put(player, Color.RED);
			break;

		case 1:
			LightRacers.getInstance().getPlayerColor().put(player, Color.GREEN);
			break;

		case 2:
			LightRacers.getInstance().getPlayerColor().put(player, Color.BLUE);
			break;

		case 3:
			LightRacers.getInstance().getPlayerColor().put(player, Color.YELLOW);
			break;

		case 4:
			LightRacers.getInstance().getPlayerColor().put(player, Color.ORANGE);
			break;

		case 5:
			LightRacers.getInstance().getPlayerColor().put(player, Color.PURPLE);
			break;

		case 6:
			LightRacers.getInstance().getPlayerColor().put(player, Color.PINK);
			break;

		default:
			LightRacers.getInstance().getPlayerColor().put(player, Color.RED);
			break;
		}

	}

}
