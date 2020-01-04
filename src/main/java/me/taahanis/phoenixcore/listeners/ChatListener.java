package me.taahanis.phoenixcore.listeners;

import me.taahanis.phoenixcore.PhoenixCore;
import me.taahanis.phoenixcore.api.PhoenixChat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener extends ListenerLoader implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        Player p = event.getPlayer();
        String nickcolor = PhoenixCore.plugin.pChat.getNickColor();
        event.setFormat("<" + nickcolor + p.getName() + "§f> " + event.getMessage());
    }
}
