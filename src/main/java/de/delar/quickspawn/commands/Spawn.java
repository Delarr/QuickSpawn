package de.delar.quickspawn.commands;

import de.delar.quickspawn.Config;
import de.delar.quickspawn.Messager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Spawn implements CommandExecutor {

    private HashMap<UUID, Long> cooldowns = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player)commandSender;

        UUID playerId = player.getUniqueId();

        long currentTime = System.currentTimeMillis();

        if(Config.cooldown > 0){
            if (cooldowns.containsKey(playerId)){
                long lastUseTime = cooldowns.get(playerId);
                long timeWaited = (currentTime - lastUseTime);

                if (timeWaited <= Config.cooldown) {
                    if(!Config.cooldownMessage.equals("off")){
                        Messager.MessagePlayer(player, Config.cooldownMessage, Messager.MessageType.ERROR);
                    }
                    Messager.MessagePlayer(player, "Cooldown: " + ((Config.cooldown/1000) - (timeWaited/1000)) + "s", Messager.MessageType.INFO);
                    return false;
                }
            }
        }

        if(Config.spawn == null){
            if(!Config.spawnNotSetMessage.equals("off")){
                Messager.MessagePlayer(player, Config.spawnNotSetMessage, Messager.MessageType.ERROR);
            }
            return false;
        }

        TeleportToSpawn(player);

        if(Config.cooldown > 0) {
            cooldowns.put(playerId, currentTime);
        }

        return false;
    }

    public static void TeleportToSpawn(Player player){
        if(Config.spawn == null){
            return;
        }

        player.teleport(Config.spawn);

        if(!Config.teleportedToSpawnMessage.equals("off")){
            Messager.MessagePlayer(player, Config.teleportedToSpawnMessage, Messager.MessageType.SUCCESS);
        }
        if(!Config.bigTeleportedToSpawnMessageTitle.equals("off")){
            if(!Config.bigTeleportedToSpawnMessageSubTitle.equals("off")){
                player.sendTitle(Config.bigTeleportedToSpawnMessageTitle, Config.bigTeleportedToSpawnMessageSubTitle, 10, 70, 20);
            }else{
                player.sendTitle(Config.bigTeleportedToSpawnMessageTitle, "", 10, 70, 20);
            }
        }
        if(Config.spawnSound != null){
            player.playSound(player.getLocation(), Config.spawnSound, 2, 1);
        }
    }
}
