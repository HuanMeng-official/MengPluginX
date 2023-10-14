package top.huanmeng.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import top.huanmeng.MengPluginX;

public class PlayerQuitEvent implements Listener {

    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent event) {
        String name = event.getPlayer().getName();
        event.setQuitMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RESET + name + "退出了" + plugin.getConfig().getString("Server"));
    }
}
