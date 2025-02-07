package me.space.mysticevents.commands;

import me.space.mysticevents.MysticEvents;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.TileState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class VaultCancelEvent implements Listener {

    @EventHandler
    public void onVaultOpening(PlayerInteractEvent e){
        if(MysticCommand.trials_enabled) {
            if (e.getClickedBlock().getType() == Material.VAULT) {
                if (e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.TRIAL_KEY)) {
                    e.setCancelled(true);
                    TileState state = (TileState) e.getClickedBlock().getState();
                    PersistentDataContainer p = state.getPersistentDataContainer();

                    if (p.has(new NamespacedKey(MysticEvents.getPlugin(), "vaultisopened"), PersistentDataType.BOOLEAN)) {
                        if(p.get(new NamespacedKey(MysticEvents.getPlugin(), "vaultisopened"), PersistentDataType.BOOLEAN)) {
                            e.setCancelled(true);
                        }
                    } else {
                        p.set(new NamespacedKey(MysticEvents.getPlugin(), "vaultisopened"), PersistentDataType.BOOLEAN, true);
                    }
                }
            }
        }
    }
}
