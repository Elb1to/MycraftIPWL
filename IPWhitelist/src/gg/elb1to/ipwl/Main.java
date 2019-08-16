package gg.elb1to.ipwl;

import org.bukkit.plugin.java.*;

import gg.elb1to.ipwl.listeners.JoinListener;

import java.util.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class Main extends JavaPlugin
{
    public static ArrayList<String> ip;
    public static Main instance;
    public static Plugin plugin;
    
    static {
        Main.ip = new ArrayList<String>();
    }
    
    public void onEnable() {
        Main.instance = this;
        ((Main)(Main.plugin = (Plugin)this)).saveDefaultConfig();
        this.check();
        this.getServer().getPluginManager().registerEvents((Listener)new JoinListener(), (Plugin)this);
        this.getServer().getConsoleSender().sendMessage("§7(§6§lIPWL§7) Ha sido activado.");
    }
    
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage("§7(§6§lIPWL§7) Ha sido desactivado.");
    }
    
    public static Plugin getPlugin() {
        return Main.plugin;
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
    
    public void check() {
        Main.ip.add(this.getConfig().getString("ip"));
    }
}
