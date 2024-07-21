package de.delar.quickspawn.commands;

import de.delar.quickspawn.Config;
import de.delar.quickspawn.Messager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!Config.tryingToReloadMessage.equals("off")){
            Messager.MessagePlayer((Player)commandSender, Config.tryingToReloadMessage, Messager.MessageType.INFO);
        }
        Bukkit.getLogger().info(Config.prefix + "Trying to reload... (Ordered by " + ((Player) commandSender).getName() + ")");
        if(Config.LoadConfig()){
            if(!Config.successfullyReloadedMessage.equals("off")){
                Messager.MessagePlayer((Player)commandSender, Config.successfullyReloadedMessage, Messager.MessageType.SUCCESS);
            }
            Bukkit.getLogger().fine("Successfully reloaded!");
        } else{
            if(!Config.errorReloading1Message.equals("off")){
                Messager.MessagePlayer((Player)commandSender, Config.errorReloading1Message, Messager.MessageType.ERROR);
            }
            if(!Config.errorReloading2Message.equals("off")){
                Messager.MessagePlayer((Player)commandSender, Config.errorReloading2Message, Messager.MessageType.INFO);
            }
            Bukkit.getLogger().severe("An error occurred while reloading.");
            Bukkit.getLogger().severe("Check the logs for more information.");
        }
        return false;
    }
}
