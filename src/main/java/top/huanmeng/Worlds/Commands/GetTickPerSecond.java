package top.huanmeng.Worlds.Commands;

import top.huanmeng.Tools.TickPerSecond;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetTickPerSecond implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            String tps = String.valueOf(TickPerSecond.getTPS());
            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "当前服务器TPS为：" + ChatColor.GREEN + tps);
        } else if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            String tps = String.valueOf(TickPerSecond.getTPS());
            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "当前服务器TPS为：" + ChatColor.GREEN + tps);
        }
        return false;
    }
}
