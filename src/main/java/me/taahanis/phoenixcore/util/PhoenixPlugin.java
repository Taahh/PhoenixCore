package me.taahanis.phoenixcore.util;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class PhoenixPlugin extends JavaPlugin {

    public abstract  void load();

    public abstract void enable();

    public abstract void disable();

    public String getPluginName()
    {
        return getDescription().getName();
    }

    public String getPluginVersion()
    {
        return getDescription().getVersion();
    }

    public String getPluginAPIVersion()
    {
        return getDescription().getAPIVersion();
    }

    public void logger(String info)
    {
        Bukkit.getLogger().info(PUtil.PREFIX + info);
    }

    public void disablePlugin()
    {
        getServer().getPluginManager().disablePlugin(this);
    }


    @Override
    public void onLoad()
    {
        load();
    }

    @Override
    public void onEnable()
    {
        enable();
    }

    @Override
    public void onDisable()
    {
        disable();
    }

}
