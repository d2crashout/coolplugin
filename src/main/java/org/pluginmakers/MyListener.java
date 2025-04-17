package org.pluginmakers;

import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Gets the player from the event
        final Player player = event.getPlayer();
        // Sends a message to the player
        player.sendMessage("Welcome to the server, " + player.getName());
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
