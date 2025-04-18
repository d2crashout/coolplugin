package org.pluginmakers.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncChatEvent event) {
        event.renderer((player, playerDisplayName, message, viewer) -> {
            if (!(viewer instanceof final Player recipient))
                return message;

            Component formattedMessage = playerDisplayName
                    .append(Component.text(" » "))
                    .append(message)
                    .color(NamedTextColor.GRAY);

            if (recipient.hasPermission("chat.moderate")) {
                Component kickComponent = Component.text("[")
                    .append(Component.text("X"))
                        .hoverEvent(HoverEvent.showText(Component.text("Kick " + player.getName(), NamedTextColor.WHITE)))
                        .clickEvent(ClickEvent.clickEvent(ClickEvent.Action.RUN_COMMAND, "/kick " + player.getName()))
                    .append(Component.text("]"))
                    .color(NamedTextColor.RED);
                return kickComponent
                        .append(Component.space())
                        .append(formattedMessage);
            }

            return formattedMessage;
        });
    }
}
