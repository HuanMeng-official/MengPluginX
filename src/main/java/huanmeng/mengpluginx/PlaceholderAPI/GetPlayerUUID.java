package huanmeng.mengpluginx.PlaceholderAPI;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetPlayerUUID implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            Player target = (Player) Bukkit.getPlayerExact(args[0]);
            String uuid = "%player_uuid%";
            uuid = PlaceholderAPI.setPlaceholders(player,uuid);
            if (target != null){
                sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "该玩家的UUID为：" + ChatColor.GREEN + uuid);
            }
        }else {
            System.out.println(ChatColor.RED + "Error: Please let the player execute the command");
        }
        return false;
    }
}
