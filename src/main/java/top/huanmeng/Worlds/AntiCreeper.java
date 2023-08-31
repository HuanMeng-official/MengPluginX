package top.huanmeng.worlds;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;
import top.huanmeng.MengPluginX;

public class AntiCreeper implements Listener {
    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void onCreeperBoom(EntityExplodeEvent event){
        if (event.getEntityType().name().equals("CREEPER")) {
            event.setCancelled(plugin.getConfig().getBoolean("AntiCreeper"));
        }
    }
}
