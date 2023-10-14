package top.huanmeng.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import top.huanmeng.MengPluginX;

public class PlayerBedEnterEvent implements Listener {
    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void onPlayerBedEvent(org.bukkit.event.player.PlayerBedEnterEvent BedEvent) {
        Player player = BedEvent.getPlayer();
        if (plugin.getConfig().getBoolean("BedEnter")) {
            if(BedEvent.getBedEnterResult() == org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult.OK) {
                player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RESET + plugin.getConfig().getString("Sleep"));
            }
        }
    }
}