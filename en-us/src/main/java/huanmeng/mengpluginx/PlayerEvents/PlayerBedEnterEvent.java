package huanmeng.mengpluginx.PlayerEvents;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class PlayerBedEnterEvent implements Listener {
    Plugin plugin = huanmeng.mengpluginx.MengPluginX.getPlugin(huanmeng.mengpluginx.MengPluginX.class);
    @EventHandler
    public void PlayerBedEvent(org.bukkit.event.player.PlayerBedEnterEvent BedEvent){
        Player sleep = BedEvent.getPlayer();
        if(BedEvent.getBedEnterResult() == org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult.OK) {
            sleep.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.WHITE + plugin.getConfig().getString("Sleep"));
        }
    }
}