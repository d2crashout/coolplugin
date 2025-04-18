package org.pluginmakers;

import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MyListener implements Listener {
    private final firstplugin plugin = JavaPlugin.getPlugin(firstplugin.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Gets the player from the event
        final Player player = event.getPlayer();
        // Gets the greeting message from config
        final String greetingMessage = plugin.getConfig().getString("Greeting-Message");
        // Sends a message to the player
        player.sendMessage(greetingMessage + " " + player.getName());
        // Remove join message
        event.setJoinMessage(null);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        player.sendMessage(ChatColor.RED + "You can't break blocks here!");
        event.setCancelled(true);
    }
}
