package me.space.mysticevents;

import me.space.mysticevents.commands.MysticCommand;
import me.space.mysticevents.commands.MysticTabComplete;
import me.space.mysticevents.commands.VaultCancelEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MysticEvents extends JavaPlugin {

    private static MysticEvents plugin;

    @Override
    public void onEnable() {
        // Set plugin static value
        plugin = this;
        // Plugin startup logging
        ConsoleCommandSender console = getServer().getConsoleSender();
        console.sendMessage("[Mystic Events] Loading plugin and configuring options...");
        // Plugin class registering and default options
        this.getCommand("mystic").setExecutor(new MysticCommand());
        getServer().getPluginManager().registerEvents(new VaultCancelEvent(), this);
        // Message that registering is done
        Bukkit.getScheduler().runTaskLater(this, new Runnable() {
            @Override
            public void run() {
                console.sendMessage("[Mystic Events] Successfully loaded the plugin!");
            }
        }, 100);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static MysticEvents getPlugin() {
        return plugin;
    }
}
