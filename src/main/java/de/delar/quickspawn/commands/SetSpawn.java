package de.delar.quickspawn.commands;

import de.delar.quickspawn.Config;
import de.delar.quickspawn.Messager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ini4j.Ini;

import java.io.IOException;

public class SetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player)commandSender;
        Location playerLocation = player.getLocation();
        Ini ini = null;
        try {
            ini = new Ini(Config.filePath.toFile());
            Ini.Section section = ini.get("CONFIGURATION");

            if (section == null) {
                section = ini.add("CONFIGURATION");
            }
            section.put("spawnWorld", playerLocation.getWorld().getName());
            section.put("spawnLocationX", playerLocation.getX());
            section.put("spawnLocationY", playerLocation.getY());
            section.put("spawnLocationZ", playerLocation.getZ());
            section.put("spawnYaw", playerLocation.getYaw());
            section.put("spawnPitch", playerLocation.getPitch());

            Config.spawn = new Location(playerLocation.getWorld(), playerLocation.getX(), playerLocation.getY(), playerLocation.getZ(), playerLocation.getYaw(), playerLocation.getPitch());

            playerLocation.getWorld().setSpawnLocation(Config.spawn);

            ini.store(Config.filePath.toFile());

            if(!Config.setServerSpawnMessage.equals("off")){
                Messager.MessagePlayer(player, Config.setServerSpawnMessage, Messager.MessageType.SUCCESS);
            }
            Bukkit.getLogger().info(player.getName() + " set the server spawn to X = " + playerLocation.getX() + ", Y = " + playerLocation.getY() + ", Z = " + playerLocation.getZ() + " (" + playerLocation.getYaw() + "/" + playerLocation.getPitch() + ") in world \"" + playerLocation.getWorld().getName() + "\"!");

            if(Config.setSpawnSound != null){
                player.playSound(player.getLocation(), Config.setSpawnSound, 2, 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
