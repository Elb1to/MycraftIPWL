package gg.elb1to.ipwl.listeners;

import org.bukkit.event.player.*;
import gg.elb1to.ipwl.Main;
import java.util.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class JoinListener implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLogin(final PlayerLoginEvent e) {
        final String ip = e.getRealAddress().toString().replace("/", "");
        if (!Main.ip.contains(ip)) {
            e.setResult(PlayerLoginEvent.Result.KICK_OTHER);
            e.setKickMessage(Main.instance.getConfig().getString("mensaje").replace("&", "§"));
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "(" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + ") " + ChatColor.RED + "Intento de Bypass desde: " + ip + " \n\t\t\tIP del retrasado: " + e.getAddress().toString().replace("/", ""));
            for (final Player p : Bukkit.getOnlinePlayers()) {
                if (p.hasPermission(Main.instance.getConfig().getString("permiso").replace("&", "§"))) {
                    p.sendMessage(ChatColor.DARK_GRAY + "(" + ChatColor.DARK_RED + "!" + ChatColor.DARK_GRAY + ") " + ChatColor.RED + "Intento de Bypass desde: " + ip + " \nIP del retrasado: " + e.getAddress().toString().replace("/", ""));
                }
            }
        }
    }
}
