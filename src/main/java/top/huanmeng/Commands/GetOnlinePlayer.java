package top.huanmeng.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static top.huanmeng.MengPluginX.m;

public class GetOnlinePlayer implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Server server = player.getServer();
            int online = server.getOnlinePlayers().size();
            player.sendMessage(m + ChatColor.RESET + "当前服务器在线玩家数量：" + ChatColor.GREEN + online);
        }else if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            consoleCommandSender.sendMessage(ChatColor.RED + "Error: Please let the op execute the command");
        }
        return false;
    }
}
