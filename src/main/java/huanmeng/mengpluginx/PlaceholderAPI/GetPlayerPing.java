package huanmeng.mengpluginx.PlaceholderAPI;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetPlayerPing implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String ping = "%player_ping%";
            ping = PlaceholderAPI.setPlaceholders(player,ping);
            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "您当前的Ping为：" + ChatColor.GREEN + ping + ChatColor.WHITE + "ms");
        }else {
            System.out.println("Error: Please let the player execute the command");
        }
        return false;
    }
}
