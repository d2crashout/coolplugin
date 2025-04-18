package org.pluginmakers.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PapiListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        String text = "Player is op: %player_is_op% (%datetime_date%, %datetime_time%)";

        text = PlaceholderAPI.setPlaceholders(player, text);
        player.sendRichMessage("<blue>" + text);
    }
}
