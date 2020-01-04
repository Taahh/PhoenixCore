package me.taahanis.phoenixcore.config;

import me.taahanis.phoenixcore.PhoenixCore;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config
{
    PhoenixCore plugin;

    public Config(PhoenixCore inst)
    {
        this.plugin = inst;

        if (!plugin.getDataFolder().exists())
        {
            plugin.getDataFolder().mkdir();
        }
    }

    public void setup()
    {
        plugin.getConfig().options().copyDefaults(true);
        save();
    }

    public void reload()
    {
        File f = new File(plugin.getDataFolder(), "config.yml");
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
        try {
            yaml.load(f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save()
    {
        plugin.saveConfig();
    }
}
