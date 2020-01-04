package me.taahanis.phoenixcore;

import me.taahanis.phoenixcore.api.PhoenixChat;
import me.taahanis.phoenixcore.api.PhoenixEco;
import me.taahanis.phoenixcore.commands.CommandLoader;
import me.taahanis.phoenixcore.config.Config;
import me.taahanis.phoenixcore.listeners.ListenerLoader;
import me.taahanis.phoenixcore.util.PhoenixPlugin;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;

public class PhoenixCore extends PhoenixPlugin {

    public static PhoenixCore plugin;

    //Modules
    public PhoenixChat pChat;
    public PhoenixEco pEco;

    //Configs
    public Config config;

    //Vault
    public Chat chat = null;

    @Override
    public void load()
    {

        plugin = this;


        logger("This is a test.");

        config = new Config(this);
        config.setup();
        logger("config.yml LOADED!");

        if (getConfig().getBoolean("phoenixcore.vault.enabled"))
        {
            setupVault();
            logger("Vault enabled!");
        }
        pChat = new PhoenixChat(this);
        pEco = new PhoenixEco(this);
    }

    @Override
    public void enable()
    {
        if (pChat.isEnabled())
        {
            setupChat();
            logger("Vault module CHAT loaded!");
        }
        if (pEco.isEnabled())
        {
            getServer().getServicesManager().register(Economy.class, pEco, this, ServicePriority.Highest);
            logger("Vault module ECONOMY loaded!");
        }


        CommandLoader.loadCMDS();
        ListenerLoader.loadListeners();
    }

    @Override
    public void disable()
    {

    }

    private void setupVault()
    {
        Plugin vault = getServer().getPluginManager().getPlugin("Vault");
        if (vault == null) {
          logger("Vault is not found, disabling plugin.");
          disablePlugin();
          return;
        }

    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

}
