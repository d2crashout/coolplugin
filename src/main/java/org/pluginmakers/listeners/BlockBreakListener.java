package org.pluginmakers.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.pluginmakers.firstplugin;

public class BlockBreakListener implements Listener {
    private final firstplugin plugin = JavaPlugin.getPlugin(firstplugin.class);

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();

        if (!player.hasPermission("myplugin.breakblocks")) {
            player.sendMessage(ChatColor.RED + "You can't break blocks here!");
            event.setCancelled(true);

        }
    }
}
