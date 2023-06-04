package top.huanmeng.Events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import top.huanmeng.MengPluginX;

public class PlayerJoinEvent implements Listener {
    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void PlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent join){
        Player player = join.getPlayer();
        String name = join.getPlayer().getName();
        join.setJoinMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RESET + "欢迎" + name + "加入" + plugin.getConfig().getString("Server"));
        player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RESET + plugin.getConfig().getString("Tips"));
        // 播放加入服务器音效
        Location location = player.getLocation();
        World world = location.getWorld();
        if (world != null) {
            world.playSound(location , Sound.ENTITY_PLAYER_LEVELUP,.5F,.5F);
        }
    }
}