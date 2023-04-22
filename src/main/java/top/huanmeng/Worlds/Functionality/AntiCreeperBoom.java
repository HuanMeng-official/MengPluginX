package top.huanmeng.Worlds.Functionality;

import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;
import top.huanmeng.MengPluginX;

public class AntiCreeperBoom implements Listener {
    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void CreeperBlocker(EntityExplodeEvent explodeEvent){
        if (explodeEvent.getEntity() instanceof Creeper) {
            explodeEvent.setCancelled(plugin.getConfig().getBoolean("AntiCreeper"));
        }
    }
}
