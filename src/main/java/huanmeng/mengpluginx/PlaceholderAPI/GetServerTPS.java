package huanmeng.mengpluginx.PlaceholderAPI;

import me.clip.placeholderapi.PlaceholderAPI;

import org.bukkit.ChatColor;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;

import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

public class GetServerTPS implements CommandExecutor {

    @Override

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            String tps = "%server_tps%";

            tps = PlaceholderAPI.setPlaceholders(player,tps);

            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "当前服务器TPS为" + ChatColor.GREEN + tps);

        }else {

            System.out.println("Error: Please let the player execute the command");

        }

        return false;

    }

}
