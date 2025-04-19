package org.pluginmakers.listeners;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;
import org.pluginmakers.firstplugin;

public class JoinListener implements Listener {
    private final firstplugin plugin = JavaPlugin.getPlugin(firstplugin.class);

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        final String playerName = player.getName();
        final String greetingMessage = plugin.getConfig().getString("greeting-message");
        final boolean customMessage = plugin.getConfig().getBoolean("custom-message");
        final String customMessageString = plugin.getConfig().getString("custom-message-string");

        Bukkit.getLogger().info("custom-message is: " + customMessage);

        if (customMessage) {
            player.sendRichMessage(customMessageString + ", " + playerName + "!");
            event.setJoinMessage(null);
        } else {
            player.sendRichMessage(greetingMessage);
        }
        event.setJoinMessage(null);
    }
}
