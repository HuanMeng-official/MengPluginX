package top.huanmeng.PlaceholderAPI;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static top.huanmeng.MengPluginX.m;

public class GetPlayerUUID implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);
            String uuid = "%player_uuid%";
            uuid = PlaceholderAPI.setPlaceholders(target,uuid);
            if (target != null){
                player.sendMessage(m + ChatColor.RESET + "该玩家的UUID为：" + ChatColor.GREEN + uuid);
            }
        }else if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            consoleCommandSender.sendMessage(ChatColor.RED + "Error: Please let the op execute the command");
        }
        return false;
    }
}
