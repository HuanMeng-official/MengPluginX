package top.huanmeng.PlaceholderAPI;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static top.huanmeng.MengPluginX.m;

public class GetPlayerUUID implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Player target = (Player) Bukkit.getPlayerExact(args[0]);
            String uuid = "%player_uuid%";
            uuid = PlaceholderAPI.setPlaceholders(target,uuid);
            if (target != null){
                sender.sendMessage(m + ChatColor.RESET + "该玩家的UUID为：" + ChatColor.GREEN + uuid);
            }
        }else {
            System.out.println(ChatColor.RED + "Error: Please let the player execute the command");
        }
        return false;
    }
}
