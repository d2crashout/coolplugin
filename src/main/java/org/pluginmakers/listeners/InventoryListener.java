package org.pluginmakers.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.pluginmakers.menu.Menu;

public class InventoryListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        final Inventory clickedInventory = event.getClickedInventory();

        if (clickedInventory == null)
            return;

        if (!(clickedInventory.getHolder() instanceof Menu menu)) {
            // Here if clicked inventory is not a menu
            return;
        }

        // Here if clicked inventory is one of our custom guis
        event.setCancelled(true);
        menu.click((Player) event.getWhoClicked(), event.getSlot());
    }
}
