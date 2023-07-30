package top.huanmeng.PlaceholderAPI;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import  static top.huanmeng.MengPluginX.m;

public class GetPlayerIP implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")){
            Player player = (Player) sender;
            Player target = (Player) Bukkit.getPlayerExact(args[0]);
            String ip = "%player_ip%";
            ip = PlaceholderAPI.setPlaceholders(target,ip);
            if (target != null){
                sender.sendMessage(m + ChatColor.RESET + "该玩家的IP为：" + ChatColor.GREEN + ip);
            }
        }else {
            sender.sendMessage(ChatColor.RED + "Error: Please let the op execute the command");
        }
        return false;
    }
}
