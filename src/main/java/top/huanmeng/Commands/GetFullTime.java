package top.huanmeng.Commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetFullTime implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")){
            Player player = (Player) sender;
            World world = player.getWorld();
            long full_time = world.getFullTime();
            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.RESET + "当前世界的绝对时间：" + ChatColor.GREEN + full_time);
        }else {
            System.out.println(ChatColor.RED + "Error: Please let the player execute the command");
        }
        return false;
    }
}
