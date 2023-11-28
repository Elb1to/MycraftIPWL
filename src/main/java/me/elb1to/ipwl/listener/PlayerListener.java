package me.elb1to.ipwl.listener;

import lombok.AllArgsConstructor;
import me.elb1to.ipwl.IPWhitelistPlugin;
import me.elb1to.ipwl.util.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * @author Elb1to
 * @since 11/27/2023
 */
@AllArgsConstructor
@SuppressWarnings("all")
public class PlayerListener implements Listener {

	private final IPWhitelistPlugin plugin;

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		String ip = event.getRealAddress().toString().replace("/", "");
		if (!plugin.getWhitelistManager().isWhitelisted(ip)) {
			event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
			event.setKickMessage(CC.color(plugin.getConfig().getString("login_denied_message")));

			String message = CC.color(plugin.getConfig().getString("bypass_attempt_message")
					.replace("<ip>", ip)
					.replace("<player>", player.getName())
					.replace("<player_ip>", event.getAddress().toString())
			);
			plugin.getLogger().info(message);
			plugin.getServer().getOnlinePlayers()
					.stream()
					.filter(online -> online.hasPermission(plugin.getConfig().getString("bypass_permission")))
					.forEach(online -> online.sendMessage(message));
		}
	}
}
