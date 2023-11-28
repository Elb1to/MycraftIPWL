package me.elb1to.ipwl.manager;

import lombok.Getter;
import me.elb1to.ipwl.IPWhitelistPlugin;

import java.util.List;

/**
 * @author Elb1to
 * @since 11/27/2023
 */
public class WhitelistManager {

	@Getter
	private final List<String> whitelistedIps;

	public WhitelistManager(IPWhitelistPlugin plugin) {
		this.whitelistedIps = plugin.getConfig().getStringList("address_list");
	}

	public boolean isWhitelisted(String ip) {
		return this.whitelistedIps.contains(ip);
	}
}
