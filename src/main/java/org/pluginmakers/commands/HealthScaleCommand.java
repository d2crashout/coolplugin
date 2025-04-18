package org.pluginmakers.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.codehaus.plexus.util.StringUtils;
import org.jetbrains.annotations.NotNull;

public class HealthScaleCommand implements CommandExecutor {
    private static final String INVALID_ARGUMENTS_MESSAGE = ChatColor.YELLOW + "Please only enter numbers from 1-20!";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        if (!(sender instanceof final Player player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Usage: /" + label + " <hearts>");
            return true;
        }

        String heartsArgument = args[0];

        if (!(StringUtils.isNumeric(heartsArgument))) {
            player.sendMessage(INVALID_ARGUMENTS_MESSAGE);
            return true;
        }

        int Hearts = Integer.parseInt(heartsArgument);

        if (Hearts <=0 || Hearts > 20) {
            player.sendMessage(INVALID_ARGUMENTS_MESSAGE);
            return true;
        }

        // input is valid

        int hearts = Hearts * 2;

        player.setHealthScale(hearts);
        player.sendMessage(ChatColor.GREEN + "Your health scale has been adjusted!");

        return true;
    }
}
