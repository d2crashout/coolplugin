package org.pluginmakers;

import org.bukkit.plugin.java.JavaPlugin;
import org.pluginmakers.commands.FlyCommand;
import org.pluginmakers.commands.HealthScaleCommand;

public class firstplugin extends JavaPlugin {

    @Override
    public void onLoad() {
        // 1.
        // This method will be called on load. NOT ENABLE

        getLogger().info("FirstPlugin has loaded!");
    }

    @Override
    public void onEnable() {
        // This method will be called on plugin enable.
        // 2.
        getLogger().info("FirstPlugin has been enabled!");

        getServer().getPluginManager().registerEvents(new MyListener(), this);

        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("healthscale").setExecutor(new HealthScaleCommand());
    }

    @Override
    public void onDisable() {
        super.onDisable();
        // 3.
        // This method will be called on server shutdown.
        getLogger().info("FirstPlugin is disabled!");
    }
}
