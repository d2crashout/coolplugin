package org.pluginmakers.commands;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import me.clip.placeholderapi.PlaceholderAPI;

import java.util.ArrayList;
import java.util.List;

public class PapiTestCommand implements TabExecutor, Listener {
    private final JavaPlugin plugin;
    public PapiTestCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String @NotNull [] args) {
        String INVALID_ARGUMENTS_MESSAGE = "<yellow>Please choose one of the allowed arguments.";

        if (args.length < 1) {
            sender.sendRichMessage("<red>Usage: /" + label + " <placeholder>");
            return true;
        } else if (args.length > 1) {
            sender.sendRichMessage("<red>Usage: /" + label + " <placeholder>");
            return true;
        }


        if (args[0].equalsIgnoreCase("all")) {
            String placeholderall = "Time: %datetime_time%" + " Date: %datetime_date%";
            String alltext = PlaceholderAPI.setPlaceholders((OfflinePlayer) sender, placeholderall);
            sender.sendRichMessage("<blue>" + alltext);
            return true;
        } else if (args[0].equalsIgnoreCase("datetime_time") || args[0].equalsIgnoreCase("datetime_date")) {
            String placeholder = "%" + args[0] + "%";
            String ptext = PlaceholderAPI.setPlaceholders((OfflinePlayer) sender, placeholder);
            sender.sendRichMessage("<blue>" + ptext);
            return true;
        }
        sender.sendRichMessage(INVALID_ARGUMENTS_MESSAGE);
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender,
                                                @NotNull Command command,
                                                @NotNull String label,
                                                @NotNull String @NotNull [] args) {
        final List<String> validArguments = new ArrayList<>();

        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], List.of("datetime_time", "datetime_date", "all"), validArguments);
            return validArguments;
        }
        return List.of();
    }
}
