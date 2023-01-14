package huanmeng.mengpluginx.Words;

import huanmeng.mengpluginx.MengPluginX;

import org.bukkit.ChatColor;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import org.bukkit.plugin.Plugin;

public class BadWords implements Listener {

    Plugin plugin = MengPluginX.getPlugin(MengPluginX.class);

    @EventHandler

    public void PlayerChat(AsyncPlayerChatEvent event) {

        Player player = (Player) event.getPlayer();

        String massage = event.getMessage();

        for (int i = 0; i < plugin.getConfig().getStringList("BadWorlds").size(); i++) {

            if (massage.contains(plugin.getConfig().getStringList("BadWorlds").get(i))) {

                event.setCancelled(plugin.getConfig().getBoolean("enable"));

                player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

            }

        }

    }

}
