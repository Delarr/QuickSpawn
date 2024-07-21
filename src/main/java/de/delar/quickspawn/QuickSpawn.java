package de.delar.quickspawn;

import de.delar.quickspawn.commands.Reload;
import de.delar.quickspawn.commands.SetSpawn;
import de.delar.quickspawn.commands.Spawn;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuickSpawn extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        Config.LoadConfig();

        getCommand("spawn").setExecutor(new Spawn());
        getCommand("setspawn").setExecutor(new SetSpawn());
        getCommand("reload").setExecutor(new Reload());
        Bukkit.getPluginManager().registerEvents(this, this);
    }


    //!!## fix
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if(Config.spawn == null){
            return;
        }

        Player player = event.getPlayer();

        if (Config.onJoin.equals("yes") || Config.onJoin.equals("true")){
            Spawn.TeleportToSpawn(player);
            return;
        }
        if (Config.onFirstJoin.equals("yes") || Config.onFirstJoin.equals("true")){
            if(!player.hasPlayedBefore()){
                Spawn.TeleportToSpawn(player);
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        if(Config.spawn == null){
            return;
        }

        Player player = e.getPlayer();

        double distanceSquared = e.getRespawnLocation().distanceSquared(Config.spawn);

        if (Config.forceOnDeath.equals("yes") || Config.forceOnDeath.equals("true")) {
            e.setRespawnLocation(Config.spawn);
            Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
                Spawn.TeleportToSpawn(player);
            }, 1L);
            return;
        }

        if (Config.onDeath.equals("yes")|| Config.onDeath.equals("true")){
            if(distanceSquared <= 1){
                e.setRespawnLocation(Config.spawn);
                Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> {
                    Spawn.TeleportToSpawn(player);
                }, 1L);
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
