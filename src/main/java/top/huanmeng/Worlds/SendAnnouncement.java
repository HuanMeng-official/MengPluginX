package top.huanmeng.Worlds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.jetbrains.annotations.NotNull;

public class SendAnnouncement implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")){
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "[公告]" + ChatColor.YELLOW + "[幻梦娘]" + ChatColor.RESET + args[0]);
        } else if (sender instanceof ConsoleCommandSender) {
            Bukkit.getServer().broadcastMessage(ChatColor.RED + "[公告]" + ChatColor.WHITE + "[幻梦娘]" + ChatColor.RESET + args[0]);
        }
        return false;
    }
}