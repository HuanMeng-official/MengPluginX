package huanmeng.mengpluginx.Worlds;

import huanmeng.mengpluginx.MengPluginX;

import org.bukkit.ChatColor;

import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;

import org.bukkit.event.Listener;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import org.bukkit.plugin.Plugin;

public class DirtyWords implements Listener {

    Plugin plugin = huanmeng.mengpluginx.MengPluginX.getPlugin(huanmeng.mengpluginx.MengPluginX.class);

    @EventHandler

    public void DirtyWords(AsyncPlayerChatEvent say) {

        if (say.getMessage().contains("sb")) {

            Player chatsay = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("傻逼")) {

            Player chatsay1 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay1.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("几把")) {

            Player chatsay2 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay2.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("他妈")) {

            Player chatsay3 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay3.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("你妈死了")) {

            Player chatsay4 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay4.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("操你妈")) {

            Player chatsay5 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay5.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("脑瘫")) {

            Player chatsay6 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay6.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("fuck")) {

            Player chatsay7 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay7.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("神经病")){

            Player chatsay8 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay8.sendMessage(ChatColor.YELLOW +plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("屎")){

            Player chatsay9 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay9.sendMessage(ChatColor.YELLOW +plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("你妈")){

            Player chatsay10 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay10.sendMessage(ChatColor.YELLOW +plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("我操")){

            Player chatsay11 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay11.sendMessage(ChatColor.YELLOW +plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("日你妈")){

            Player chatsay12 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay12.sendMessage(ChatColor.YELLOW +plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

        if (say.getMessage().contains("操逼")){

            Player chatsay13 = say.getPlayer();

            say.setCancelled(plugin.getConfig().getBoolean("PlayChatEvent"));

            chatsay13.sendMessage(ChatColor.YELLOW +plugin.getConfig().getString("Characters") + ChatColor.RED + plugin.getConfig().getString("Alert"));

        }

    }

}
