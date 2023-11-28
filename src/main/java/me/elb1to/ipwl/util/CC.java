package me.elb1to.ipwl.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elb1to
 * @since 11/27/2023
 */
@UtilityClass
public class CC {

	public String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public List<String> color(List<String> lines) {
		List<String> strings = new ArrayList<>();
		for (String line : lines) {
			strings.add(ChatColor.translateAlternateColorCodes('&', color(line)));
		}

		return strings;
	}

	public List<String> color(String[] lines) {
		List<String> strings = new ArrayList<>();
		for (String line : lines) {
			if (line != null) {
				strings.add(ChatColor.translateAlternateColorCodes('&', color(line)));
			}
		}

		return strings;
	}
}
