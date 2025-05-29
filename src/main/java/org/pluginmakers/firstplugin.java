package org.pluginmakers;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.pluginmakers.commands.*;
import org.pluginmakers.listeners.*;
import org.pluginmakers.placeholders.*;

public class firstplugin extends JavaPlugin {

    private boolean blockProtection = false;

    public boolean isBlockProtectionEnabled() {
        return blockProtection;
    }

    public void setBlockProtectionStatus(boolean status) {
        this.blockProtection = status;
    }

    private void registerListeners() {
        @NotNull PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new MainListener(), this);
        pm.registerEvents(new PapiListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new InventoryListener(), this);
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new JoinListener(), this);
    }

    private void registerCommands() {
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("healthscale").setExecutor(new HealthScaleCommand());
        getCommand("testplaceholders").setExecutor(new PapiTestCommand(this));
        getCommand("killgui").setExecutor(new KillCommand());
        getCommand("skin").setExecutor(new SkinChangeCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("blockpro").setExecutor(new BlockProtectionCommand(this));
    }

    private void registerRecipes() {
        final ItemStack diamond = new ItemStack(Material.DIAMOND);
        final ItemMeta dMeta = diamond.getItemMeta();
        dMeta.displayName(Component.text("Special Diamond", NamedTextColor.DARK_PURPLE));
        diamond.setItemMeta(dMeta);

        final NamespacedKey key = new NamespacedKey(this, "special_diamond");
        final ShapedRecipe recipe = new ShapedRecipe(key, diamond);
        recipe.shape(
                "GGG",
                "GIG",
                "GGG"
        );

        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('I', Material.IRON_INGOT);
        Bukkit.addRecipe(recipe);
    }

    public void registerCustomPlaceholders() {
        new DateTimePlaceholder(this).register();
    }

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
        saveDefaultConfig();

        final Plugin papi = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");

        getLogger().info("FirstPlugin has been enabled!");

        registerListeners();
        registerCommands();
        registerCustomPlaceholders();
        registerRecipes();


        if (!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI") || papi == null || !papi.isEnabled()) {
            // Here is PAPI is not on the server
            Bukkit.getConsoleSender().sendRichMessage("<red>PlaceholderAPI plugin is needed!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        // Here if PAPI is on the server
    }

    @Override
    public void onDisable() {
        super.onDisable();
        // 3.
        // This method will be called on server shutdown.
        getLogger().info("FirstPlugin is disabled!");
    }

}
