package me.taahanis.phoenixcore.listeners;

import me.taahanis.phoenixcore.PhoenixCore;
import me.taahanis.phoenixcore.api.PhoenixChat;
import org.bukkit.plugin.PluginManager;
import sun.plugin2.main.server.Plugin;

public class ListenerLoader
{
    private static PhoenixCore plugin = PhoenixCore.getPlugin(PhoenixCore.class);
    public static void loadListeners()
    {
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(new ChatListener(), plugin);
    }
}
