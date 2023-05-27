package top.huanmeng.Worlds.Functionality;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.plugin.Plugin;
import top.huanmeng.MengPluginX;

public class AntiEnderMan implements Listener {
    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void onEnderManPickupBlock(EntityChangeBlockEvent event){
        if (event.getEntityType() == EntityType.ENDERMAN){
            if (event.getTo() == Material.AIR){
                event.setCancelled(plugin.getConfig().getBoolean("AntiEnderMan"));
            } else if (event.getBlock().getType() == Material.AIR) {
                event.setCancelled(plugin.getConfig().getBoolean("AntiEnderMan"));
            }
        }
    }
}
