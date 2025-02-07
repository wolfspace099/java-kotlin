package me.space.mysticevents.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MysticCommand implements CommandExecutor {

    public static boolean uhc_enabled = true;
    public static boolean trials_enabled = true;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String prefix = ChatColor.LIGHT_PURPLE + "[Mystic \uD83D\uDC8E Events] " + ChatColor.WHITE;
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;

            if(strings.length > 0){
                if(strings.length == 1){
                    if(strings[0].equals("uhc")){
                        if(uhc_enabled) {
                            p.performCommand("gamerule naturalRegeneration true");
                            uhc_enabled = false;
                            p.sendMessage(prefix + "Disabled UHC mode, natural regen is now enabled");
                        }else{
                            p.performCommand("gamerule naturalRegeneration false");
                            uhc_enabled = true;
                            p.sendMessage(prefix + "Enabled UHC mode, natural regen is now disabled");
                        }
                    }else if(strings[0].equals("trials")){
                        if(trials_enabled) {
                            trials_enabled = false;
                            p.sendMessage(prefix + "Disabled Trails mode, vaults can now be opened multiple times");
                        }else{
                            trials_enabled = true;
                            p.sendMessage(prefix + "Enabled Trails mode, vaults can now be opened only onces");
                        }
                    }
                }else{
                    commandSender.sendMessage(prefix + "Incorrect usage of command! Use /mystic help");
                }
            }else{
                commandSender.sendMessage(prefix + "Incorrect usage of command! Use /mystic help");
            }
        }else{
            commandSender.sendMessage(prefix + "This command can only be executed by players!");
        }

        return true;
    }
}
