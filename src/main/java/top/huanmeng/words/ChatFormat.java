package top.huanmeng.words;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormat implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        e.setFormat(
                ChatColor.GRAY + "[" + ChatColor.GOLD + player.getWorld().getName() + ChatColor.GRAY + "]" +
                ChatColor.AQUA + player.getName() +
                ChatColor.WHITE + ": " +
                ChatColor.RESET + e.getMessage());
    }
}
