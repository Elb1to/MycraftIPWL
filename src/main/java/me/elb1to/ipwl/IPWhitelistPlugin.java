package me.elb1to.ipwl;

import lombok.Getter;
import me.elb1to.ipwl.listener.PlayerListener;
import me.elb1to.ipwl.manager.WhitelistManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Elb1to
 * @since 11/27/2023
 */
public class IPWhitelistPlugin extends JavaPlugin {

	@Getter
	private WhitelistManager whitelistManager;

	public void onEnable() {
		saveDefaultConfig();

		whitelistManager = new WhitelistManager(this);
		getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}
}
