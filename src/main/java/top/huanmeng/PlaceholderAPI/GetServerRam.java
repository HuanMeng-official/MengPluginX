package top.huanmeng.PlaceholderAPI;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GetServerRam implements CommandExecutor , TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")) {
            Player player = (Player) sender;
            String used_ram = "%server_ram_used%";
            used_ram = PlaceholderAPI.setPlaceholders(player,used_ram);
            String free_ram = "%server_ram_free%";
            free_ram = PlaceholderAPI.setPlaceholders(player,free_ram);
            String total_ram = "%server_ram_total%";
            total_ram = PlaceholderAPI.setPlaceholders(player,total_ram);
            String ram = args[0];
            switch (ram) {
                case "used":
                    player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "当前服务器已用内存：" + ChatColor.GREEN + used_ram + ChatColor.WHITE + "MB");
                    break;
                case "free":
                    player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "当前服务器剩余内存：" + ChatColor.GREEN + free_ram + ChatColor.WHITE + "MB");
                    break;
                case "total":
                    player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "当前服务器总共内存：" + ChatColor.GREEN + total_ram + ChatColor.WHITE + "MB");
                    break;
            }
        } else if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            sender.sendMessage(ChatColor.RED + "Error: Please let the player execute the command");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("used");
            list.add("free");
            list.add("total");
            return list;
        }
        return null;
    }
}
