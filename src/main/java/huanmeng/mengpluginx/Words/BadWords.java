package huanmeng.mengpluginx.Words;

import huanmeng.mengpluginx.MengPluginX;
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
    File file = new File(huanmeng.mengpluginx.MengPluginX.getPlugin(huanmeng.mengpluginx.MengPluginX.class).getDataFolder(),"keywords.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(file);
    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);
    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) {
        Player player = (Player) event.getPlayer();
        String massage = event.getMessage();
        for (int i = 0; i < config.getStringList("key-words").size(); i++) {
            if (massage.contains(config.getStringList("key-words").get(i))) {
                event.setCancelled(plugin.getConfig().getBoolean("BadWords"));
                player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));
            }
        }
    }
}
