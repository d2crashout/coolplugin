package org.pluginmakers.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.pluginmakers.firstplugin;

import java.util.ArrayList;
import java.util.List;

public class BlockProtectionCommand implements TabExecutor {
    private final firstplugin plugin;

    public BlockProtectionCommand(firstplugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        boolean blockProtectionStatus = plugin.isBlockProtectionEnabled();

        if (args.length != 1) {
            sender.sendRichMessage("<red>Usage: /blockpro <true, false>");
            return true;
        } else if (args[0].equalsIgnoreCase("true")) {
            sender.sendRichMessage("<green>Block protection turned on!");
            plugin.setBlockProtectionStatus(true);
            return true;
        } else if (args[0].equalsIgnoreCase("false")) {
            sender.sendRichMessage("<green>Block protection turned off!");
            plugin.setBlockProtectionStatus(false);
            return true;
        } else {
            sender.sendRichMessage("<red>Usage: /blockpro <true, false>");
            return true;
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        final List<String> validArguments = new ArrayList<>();

        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], List.of("false", "true"), validArguments);
            return validArguments;
        }
        return List.of();
    }
}
