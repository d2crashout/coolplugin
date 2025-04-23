package org.pluginmakers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class VanishCommand implements TabExecutor {

    private final Set<UUID> vanishedPlayers = new HashSet<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        Player targetPlayer = null;

        // /vanish -> toggle status of self
        if (args.length == 0) {
            if (!(sender instanceof final Player player)) {
                sender.sendRichMessage("<yellow>Please specify a player name if running from the console.");
                return true;
            }

            targetPlayer = (Player) sender;

        // /vanish <player> -> toggle status of other player
        } else {
            targetPlayer = Bukkit.getPlayer(args[0]);

            if (args.length != 1) {
                sender.sendRichMessage("<red>Usage: /vanish <player>");
            }

            if (targetPlayer == null) {
                sender.sendRichMessage("<red>Player " + args[0] + " not found");

                return true;
            }
        }

        UUID uniqueId = targetPlayer.getUniqueId();
        boolean isVanished = vanishedPlayers.contains(uniqueId);

        for (Player otherPlayer: Bukkit.getOnlinePlayers()) {
            if (otherPlayer.equals(targetPlayer)) {
                continue;
            }

            if (isVanished) {
                otherPlayer.showPlayer(targetPlayer);
            } else {
                otherPlayer.hidePlayer(targetPlayer);
            }
        }

        sender.sendRichMessage("<green>Player " + targetPlayer.getName() + " is now " + (isVanished ? "visible" : "invisible") + ".");

        if (isVanished) {
            vanishedPlayers.remove(uniqueId);
        } else {
            vanishedPlayers.add(uniqueId);
        }

        return true;
    }

    
    
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
