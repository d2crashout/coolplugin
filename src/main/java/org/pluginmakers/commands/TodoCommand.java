package org.pluginmakers.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TodoCommand implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String @NotNull [] args) {
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender,
                                                @NotNull Command command,
                                                @NotNull String label,
                                                @NotNull String @NotNull [] args) {
        final List<String> validArguments = new ArrayList<>();

        if (args.length == 1) {
            // /todo <add | remove>
            StringUtil.copyPartialMatches(args[0], List.of("add", "remove"), validArguments);
            return validArguments;
        }
        return List.of();
    }
}
