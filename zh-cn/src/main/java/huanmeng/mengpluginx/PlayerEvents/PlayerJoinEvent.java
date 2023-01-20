package huanmeng.mengpluginx.PlayerEvents;

import huanmeng.mengpluginx.MengPluginX;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class PlayerJoinEvent implements Listener {
    Plugin plugin = huanmeng.mengpluginx.MengPluginX.getPlugin(huanmeng.mengpluginx.MengPluginX.class);
    @EventHandler
    public void PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent join){
        Player player = join.getPlayer();
        String name = join.getPlayer().getName();
        player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.WHITE + "欢迎" + name + "加入" + plugin.getConfig().getString("Server"));
        player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.WHITE + plugin.getConfig().getString("Tips"));
    }
}
