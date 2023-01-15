package huanmeng.mengpluginx.Worlds;

import org.bukkit.ChatColor;
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
            String full_time = String.valueOf(player.getWorld().getFullTime());
            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "当前世界的绝对时间：" + ChatColor.GREEN + full_time);
        }else {
            System.out.println("Error: Please let the player execute the command");
        }
        return false;
    }
}
