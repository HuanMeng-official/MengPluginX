package top.huanmeng.Worlds;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;
import top.huanmeng.MengPluginX;

public class KeepInventory implements Listener {
    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent event) {
        if (plugin.getConfig().getBoolean("KeepInventory")) {
            event.setKeepInventory(true);
            event.setKeepLevel(true);
        } else if (plugin.getConfig().getBoolean("KeepInventory")) {
            event.setKeepInventory(false);
            event.setKeepLevel(false);
        }
    }
}