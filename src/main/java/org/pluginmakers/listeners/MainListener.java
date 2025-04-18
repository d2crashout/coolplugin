package org.pluginmakers.listeners;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.pluginmakers.firstplugin;

public class MainListener implements Listener {
    private final firstplugin plugin = JavaPlugin.getPlugin(firstplugin.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Gets the player from the event
        final Player player = event.getPlayer();
        // Gets the greeting message from config
        final String greetingMessage = plugin.getConfig().getString("Greeting-Message");
        // Sends a message to the player
        event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize(greetingMessage));
        // Remove join message
        event.setJoinMessage(null);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();

        if (!player.hasPermission("myplugin.breakblocks")) {
            player.sendMessage(ChatColor.RED + "You can't break blocks here!");
            event.setCancelled(true);

        }
    }
}
