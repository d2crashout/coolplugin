package org.pluginmakers.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalTime;
import java.util.Date;

public class DateTimePlaceholder extends PlaceholderExpansion {
    private final JavaPlugin plugin;

    public DateTimePlaceholder(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    // %datetime_date% - Shows today's date
    // %datetime_time% - Shows current time
    @Override
    public @NotNull String getIdentifier() {
        return "datetime";
    }

    @Override
    public @NotNull String getAuthor() {
        return String.join(", ", plugin.getPluginMeta().getAuthors());
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getPluginMeta().getVersion();
    }

    @Override
    public @Nullable String onRequest(OfflinePlayer player, @NotNull String params) {
        if (params.equalsIgnoreCase("date")) {
            // Here is placeholder is %datetime_date%
            final Date date = new Date();
            return date.toString();
        } else if (params.equalsIgnoreCase("time")) {
            // Here if placeholder is %datetime_time%
            final LocalTime time = LocalTime.now();
            return time.toString();
        }

        // Here if placeholder is %datetime_somethingelse%
        return null;
    }
}
