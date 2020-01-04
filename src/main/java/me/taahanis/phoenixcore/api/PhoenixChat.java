package me.taahanis.phoenixcore.api;

import me.taahanis.phoenixcore.PhoenixCore;
import org.bukkit.ChatColor;

public class PhoenixChat
{

    public PhoenixCore plugin;
    public PhoenixChat(PhoenixCore inst)
    {
        this.plugin = inst;
    }

    public String getNickColor()
    {
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("phoenixcore.general.nickname-color"));
    }

    public boolean isEnabled()
    {
        return plugin.getConfig().getBoolean("phoenixcore.vault.chat.enabled");
    }

}
