package huanmeng.mengpluginx.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandHelp implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            sender.sendMessage(ChatColor.GREEN + "------基础命令------");
            sender.sendMessage(ChatColor.YELLOW + "/mpx 插件信息");
            sender.sendMessage(ChatColor.YELLOW + "/mpx_help 插件帮助");
            sender.sendMessage(ChatColor.GREEN + "------功能命令------");
            sender.sendMessage(ChatColor.YELLOW + "/mpx_ip 查看玩家IP（仅管理员）");
            sender.sendMessage(ChatColor.YELLOW + "/mpx_ping 查看自己与服务器的延迟");
            sender.sendMessage(ChatColor.YELLOW + "/mpx_tps 查看服务器当前TPS");
            sender.sendMessage(ChatColor.YELLOW + "/mpx_uuid 查看玩家UUID");
            sender.sendMessage(ChatColor.YELLOW + "/online_player 获取当前服务器在线玩家数量");
            sender.sendMessage(ChatColor.GREEN + "------世界命令------");
            sender.sendMessage(ChatColor.YELLOW + "/mpx_seed 获取自己所在世界的种子");
            sender.sendMessage(ChatColor.YELLOW + "/mpx_time 获取自己所在世界的绝对时间");
            sender.sendMessage(ChatColor.GREEN + "------服务器------");
            sender.sendMessage(ChatColor.YELLOW + "/mpx_ram 获取服务器当前已用/剩余内存");
        }else {
            System.out.println(ChatColor.RED + "Error: Please let the player execute the command");
        }
        return false;
    }
}
