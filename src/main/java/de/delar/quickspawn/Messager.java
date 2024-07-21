package de.delar.quickspawn;

import org.bukkit.entity.Player;

public class Messager {
    public static void MessagePlayer(Player player, String message, MessageType type){
        switch (type){
            case ERROR:
                player.sendMessage(Config.prefix + "§c" + message);
                break;
            case INFO:
                player.sendMessage(Config.prefix + "§e" + message);
                break;
            case SUCCESS:
                player.sendMessage(Config.prefix + "§a" + message);
                break;
        }
    }

    public static void MessagePlayer(Player player, String message){
        player.sendMessage(Config.prefix + message);
    }

    public static enum MessageType {
        ERROR,
        INFO,
        SUCCESS
    }
}
