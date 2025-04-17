package org.pluginmakers.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        if (!(sender instanceof Player)) {
            // here is sender is not a player
            sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
            return true;
        }

        // here is sender is a player

        final Player player = (Player) sender;

        player.setAllowFlight(true);
        player.setFlying(true);
        player.sendMessage(ChatColor.GREEN + "You are now flying!");

        return true;
    }
}
