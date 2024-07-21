package de.delar.quickspawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.ini4j.Ini;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {

    public static final Path folderPath = Paths.get("./plugins/QuickSpawn");
    public static final Path filePath = folderPath.resolve("config.ini");

    public static String prefix = "[QuickSpawn] ";

    public static Location spawn = null;

    public static String logPrefix = "[QuickSpawn] ";

    public static String pluginName = "QuickSpawn";

    public static String onDeath = "no";
    public static String forceOnDeath = "no";
    public static String onJoin = "no";
    public static String onFirstJoin = "no";
    public static Sound setSpawnSound = null;
    public static Sound spawnSound = null;
    public static long cooldown = 0;

    public static String tryingToReloadMessage = "off";
    public static String successfullyReloadedMessage = "off";
    public static String errorReloading1Message = "off";
    public static String errorReloading2Message = "off";
    public static String setServerSpawnMessage = "off";
    public static String spawnNotSetMessage = "off";
    public static String teleportedToSpawnMessage = "off";
    public static String bigTeleportedToSpawnMessageTitle = "off";
    public static String bigTeleportedToSpawnMessageSubTitle = "off";
    public static String cooldownMessage = "off";

    private static Ini ini = null;

    public static boolean LoadConfig (){
        try {
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
                Bukkit.getLogger().warning(logPrefix + "Youre starting " + pluginName + " for the first time! Thank you for choosing us.");
            }

            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                try (FileWriter writer = new FileWriter(filePath.toFile().getPath(), false)) {
                    writer.write("[CONFIGURATION]\n" +
                            "#\n" +
                            "# The prefix used in messages from the plugin.\n" +
                            "# Overwrites the default prefix.\n" +
                            "# Use the \"§\" symbol for color codes.\n" +
                            "# For more information: https://htmlcolorcodes.com/minecraft-color-codes/\n" +
                            "prefix=§9§lQuickSpawn §8➢ §r \n" +
                            "#\n" +
                            "# The world name where the spawn location is set.\n" +
                            "spawnWorld=world\n" +
                            "#\n" +
                            "# The X coordinate of the spawn location.\n" +
                            "spawnLocationX=\n" +
                            "#\n" +
                            "# The Y coordinate of the spawn location.\n" +
                            "spawnLocationY=\n" +
                            "#\n" +
                            "# The Z coordinate of the spawn location.\n" +
                            "spawnLocationZ=\n" +
                            "#\n" +
                            "# The yaw of the spawn location.\n" +
                            "spawnYaw=\n" +
                            "#\n" +
                            "# The pitch of the spawn location.\n" +
                            "spawnPitch=\n" +
                            "#\n" +
                            "# The time (in milliseconds) that a player has to wait to do /spawn again.\n" +
                            "# Write 0 to disable the cooldown.\n" +
                            "cooldown=10000\n" +
                            "#\n" +
                            "#\n" +
                            "#\n" +
                            "# Answer the questions below with true/yes or false/no.\n" +
                            "#\n" +
                            "#\n" +
                            "#\n" +
                            "# Respawn player at the spawn when they die?\n" +
                            "# Strongly advised\n" +
                            "teleportOnDeath=yes\n" +
                            "#\n" +
                            "# Forcefully overwrite any respawn point no matter what?\n" +
                            "# Overwrites individual player bed respawn points and any other respawn point that is not the set server spawn.\n" +
                            "forceTeleportOnDeath=yes\n" +
                            "#\n" +
                            "# Teleport player to the spawn every time they join? (Doesn't include first-time joins)\n" +
                            "teleportOnJoin=yes\n" +
                            "#\n" +
                            "# Spawn player at the spawn when they join for the first time?\n" +
                            "teleportOnFirstJoin=yes\n" +
                            "#\n" +
                            "#\n" +
                            "#\n" +
                            "# To see a list of all available sounds for the options below, see https://minecraft.fandom.com/wiki/Sounds.json#Java_Edition_values\n" +
                            "#\n" +
                            "#\n" +
                            "#\n" +
                            "# Sound to play when the spawn is set successfully.\n" +
                            "# Leave empty if no sound should play.\n" +
                            "setSpawnSound=block.note.block.pling\n" +
                            "#\n" +
                            "# Sound to play when teleported to spawn.\n" +
                            "# Leave empty if no sound should play.\n" +
                            "teleportToSpawnSound=entity.player.levelup\n" +
                            "#\n" +
                            "#\n" +
                            "#\n" +
                            "# Game messages by this plugin.\n" +
                            "# Write \"off\" to turn the message off.\n" +
                            "# Use the \"§\" symbol for color codes.\n" +
                            "# This plugin will use its own colors by default, but you can overwrite them.\n" +
                            "# For more information, see https://htmlcolorcodes.com/minecraft-color-codes/\n" +
                            "#\n" +
                            "#\n" +
                            "#\n" +
                            "# Reload info. Default: Trying to reload...\n" +
                            "tryingToReloadMessage=Trying to reload...\n" +
                            "#\n" +
                            "# Reload successful. Default: Successfully reloaded!\n" +
                            "successfullyReloadedMessage=Successfully reloaded!\n" +
                            "#\n" +
                            "# Error reloading. Default: An error occurred while reloading.\n" +
                            "errorReloading1Message=An error occurred while reloading.\n" +
                            "#\n" +
                            "# More information regarding reload error. Default: Check the logs for more information.\n" +
                            "errorReloading2Message=Check the logs for more information.\n" +
                            "#\n" +
                            "# Successfully set new server spawn. Default: You successfully set the new server spawn!\n" +
                            "setServerSpawnMessage=You successfully set the new server spawn!\n" +
                            "#\n" +
                            "# When the spawn is not set yet on /spawn. Default: The spawn is not set yet.\n" +
                            "spawnNotSetMessage=The spawn is not set yet.\n" +
                            "#\n" +
                            "# Message in chat when teleported to the spawn. Default: Welcome to the spawn!\n" +
                            "teleportedToSpawnMessage=Welcome to the spawn!\n" +
                            "#\n" +
                            "# Big message on screen when teleported to the spawn. (Title of that message) Default: Welcome\n" +
                            "bigTeleportedToSpawnTitleMessage=Welcome\n" +
                            "#\n" +
                            "# Big message on screen when teleported to the spawn. (Subtitle of that message) Default: to the spawn!\n" +
                            "# Important: This will work ONLY when the previous message (Title) is enabled as well.\n" +
                            "bigTeleportedToSpawnSubTitleMessage=to the spawn!\n" +
                            "#\n" +
                            "# Message when player has to wait for the cooldown. Default: Sorry, you can't do that yet!\n" +
                            "cooldownMessage=Sorry, you can't do that yet!\n" +
                            "#\n");
                    Bukkit.getLogger().warning(logPrefix + "Created config file due to its non-existence.");
                } catch (IOException e) {
                    Bukkit.getLogger().severe(logPrefix + "Failed creating config file: " + e.getMessage());
                    return false;
                }
            }
        }
        catch (IOException e) {
            Bukkit.getLogger().severe(logPrefix + "A problem occurred while checking the config file: " + e.getMessage());
            return false;
        }

        try {
            ini = new Ini(filePath.toFile());

            String configPrefix = ini.get("CONFIGURATION", "prefix", String.class);
            if (configPrefix != null) {
                prefix = configPrefix;
                Bukkit.getLogger().info(logPrefix + "Prefix resolved from config file: " + prefix);
            } else {
                Bukkit.getLogger().info(logPrefix + "No prefix found in config file. Using " + prefix + " instead.");
            }

            String worldName = ini.get("CONFIGURATION", "spawnWorld", String.class);
            String x = ini.get("CONFIGURATION", "spawnLocationX", String.class);
            String y = ini.get("CONFIGURATION", "spawnLocationY", String.class);
            String z = ini.get("CONFIGURATION", "spawnLocationZ", String.class);
            String yaw = ini.get("CONFIGURATION", "spawnYaw", String.class);
            String pitch = ini.get("CONFIGURATION", "spawnPitch", String.class);
            String cooldownString = ini.get("CONFIGURATION", "cooldown", String.class);
            onDeath = ini.get("CONFIGURATION", "teleportOnDeath", String.class);
            forceOnDeath = ini.get("CONFIGURATION", "forceTeleportOnDeath", String.class);
            onJoin = ini.get("CONFIGURATION", "teleportOnJoin", String.class);
            onFirstJoin = ini.get("CONFIGURATION", "teleportOnFirstJoin", String.class);
            String stringSetSpawnSound = ini.get("CONFIGURATION", "setSpawnSound", String.class).toUpperCase().replace('.', '_');
            String stringSpawnSound = ini.get("CONFIGURATION", "teleportToSpawnSound", String.class).toUpperCase().replace('.', '_');
            if(stringSetSpawnSound != null){
                try {
                    setSpawnSound = Sound.valueOf(stringSetSpawnSound);
                } catch (IllegalArgumentException e) {
                    Bukkit.getLogger().warning(logPrefix + "Couldn't set /setspawn sound. Using no sound.");
                }
            } else{
                Bukkit.getLogger().warning(logPrefix + "Couldn't set /setspawn sound. Using no sound.");
            }
            if(stringSpawnSound != null){
                try {
                    spawnSound = Sound.valueOf(stringSpawnSound);
                } catch (IllegalArgumentException e) {
                    Bukkit.getLogger().warning(logPrefix + "Couldn't set /spawn sound. Using no sound.");
                }
            } else{
                Bukkit.getLogger().warning(logPrefix + "Couldn't set /spawn sound. Using no sound.");
            }

            tryingToReloadMessage = ini.get("CONFIGURATION", "tryingToReloadMessage", String.class);
            successfullyReloadedMessage = ini.get("CONFIGURATION", "successfullyReloadedMessage", String.class);
            errorReloading1Message = ini.get("CONFIGURATION", "errorReloading1Message", String.class);
            errorReloading2Message = ini.get("CONFIGURATION", "errorReloading2Message", String.class);
            setServerSpawnMessage = ini.get("CONFIGURATION", "setServerSpawnMessage", String.class);
            spawnNotSetMessage = ini.get("CONFIGURATION", "spawnNotSetMessage", String.class);
            teleportedToSpawnMessage = ini.get("CONFIGURATION", "teleportedToSpawnMessage", String.class);
            bigTeleportedToSpawnMessageTitle = ini.get("CONFIGURATION", "bigTeleportedToSpawnTitleMessage", String.class);
            bigTeleportedToSpawnMessageSubTitle = ini.get("CONFIGURATION", "bigTeleportedToSpawnSubTitleMessage", String.class);
            cooldownMessage = ini.get("CONFIGURATION", "cooldownMessage", String.class);
            if(tryingToReloadMessage == null){
                tryingToReloadMessage = "off";
            }
            if(successfullyReloadedMessage == null){
                successfullyReloadedMessage = "off";
            }
            if(errorReloading1Message == null){
                errorReloading1Message = "off";
            }
            if(errorReloading2Message == null){
                errorReloading2Message = "off";
            }
            if(setServerSpawnMessage == null){
                setServerSpawnMessage = "off";
            }
            if(spawnNotSetMessage == null){
                spawnNotSetMessage = "off";
            }
            if(teleportedToSpawnMessage == null){
                teleportedToSpawnMessage = "off";
            }
            if(bigTeleportedToSpawnMessageTitle == null){
                bigTeleportedToSpawnMessageTitle = "off";
            }
            if(bigTeleportedToSpawnMessageSubTitle == null){
                bigTeleportedToSpawnMessageSubTitle = "off";
            }
            if(cooldownMessage == null){
                cooldownMessage = "off";
            }

            if (worldName == null || worldName.trim().isEmpty() || x == null || x.trim().isEmpty() || y == null || y.trim().isEmpty() || z == null || z.trim().isEmpty() || yaw == null || yaw.trim().isEmpty() || pitch == null || pitch.trim().isEmpty()) {
                Bukkit.getLogger().warning(logPrefix + "Config file is missing valid location keys for the server spawn point. Edit the config file or use /setspawn in the game to set the server spawn.");
            } else {
                try {
                    Double xDouble = Double.parseDouble(x);
                    Double yDouble = Double.parseDouble(y);
                    Double zDouble = Double.parseDouble(z);
                    Float yawFloat = Float.parseFloat(yaw);
                    Float pitchFloat = Float.parseFloat(pitch);

                    if (Bukkit.getWorld(worldName) != null) {
                        spawn = new Location(Bukkit.getWorld(worldName), xDouble, yDouble, zDouble, yawFloat, pitchFloat);
                        Bukkit.getLogger().info(logPrefix + "Spawn location loaded from config file.");
                        Bukkit.getLogger().info(logPrefix + "Set the server spawn to X = " + spawn.getX() + ", Y = " + spawn.getY() + ", Z = " + spawn.getZ() + " (" + spawn.getYaw() + "/" + spawn.getPitch() + ") in world \"" + spawn.getWorld().getName() + "\"!");
                    } else {
                        Bukkit.getLogger().warning(logPrefix + "World " + worldName + " not found.");
                        return false;
                    }
                } catch (NumberFormatException e) {
                    Bukkit.getLogger().severe(logPrefix + e.getMessage());
                }
            }
            if (cooldownString == null || cooldownString.trim().isEmpty()) {
                Bukkit.getLogger().warning(logPrefix + "Config file does not include a valid cooldown time.");
            } else {
                try {
                    cooldown = Long.parseLong(cooldownString);
                    Bukkit.getLogger().info(logPrefix + "Set cooldown time to " + cooldown + "ms!");
                } catch (NumberFormatException e) {
                    Bukkit.getLogger().severe(logPrefix + e.getMessage());
                }
            }
            return true;
        }catch (IOException e){
            Bukkit.getLogger().severe(logPrefix + "Unable to load the configuration!");
            return false;
        }
    }
}
