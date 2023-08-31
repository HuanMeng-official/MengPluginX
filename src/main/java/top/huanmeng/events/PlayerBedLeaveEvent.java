package top.huanmeng.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import top.huanmeng.MengPluginX;

public class PlayerBedLeaveEvent implements Listener {
    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void PlayerBedLeave(org.bukkit.event.player.PlayerBedLeaveEvent BedLeave){
        Player getup = BedLeave.getPlayer();
        getup.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RESET + plugin.getConfig().getString("Getup"));
    }
}
