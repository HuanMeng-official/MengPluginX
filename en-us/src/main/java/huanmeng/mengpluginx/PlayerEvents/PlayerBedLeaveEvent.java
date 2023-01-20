package huanmeng.mengpluginx.PlayerEvents;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class PlayerBedLeaveEvent implements Listener {
    Plugin plugin = huanmeng.mengpluginx.MengPluginX.getPlugin(huanmeng.mengpluginx.MengPluginX.class);
    @EventHandler
    public void PlayerBedLeaveEvent(org.bukkit.event.player.PlayerBedLeaveEvent BedLeave){
        Player getup = BedLeave.getPlayer();
        getup.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.WHITE + plugin.getConfig().getString("Getup"));
    }
}
