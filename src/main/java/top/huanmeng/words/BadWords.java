package top.huanmeng.words;

import top.huanmeng.MengPluginX;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class BadWords implements Listener {
    File file = new File(MengPluginX.getPlugin(MengPluginX.class).getDataFolder(),"keywords.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(file);
    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String massage = event.getMessage();
        for (int i = 0; i < config.getStringList("Words").size(); i++) {
            if (massage.contains(config.getStringList("Words").get(i))) {
                event.setCancelled(plugin.getConfig().getBoolean("BadWords"));
                player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));
            }
        }
    }
}
