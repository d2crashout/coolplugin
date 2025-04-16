package org.pluginmakers;

import org.bukkit.plugin.java.JavaPlugin;

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

        getLogger().severe("Test error message. Its all okay.");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        // 3.
        // This method will be called on server shutdown.
        getLogger().info("FirstPlugin is disabled!");
    }
}
