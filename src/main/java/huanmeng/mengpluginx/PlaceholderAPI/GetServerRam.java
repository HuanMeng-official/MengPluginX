package huanmeng.mengpluginx.PlaceholderAPI;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GetServerRam implements CommandExecutor , TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")) {
            Player player = (Player) sender;
            //已使用RAM
            String used_ram = "%server_ram_used%";
            used_ram = PlaceholderAPI.setPlaceholders(player,used_ram);
            //未使用RAM
            String free_ram = "%server_ram_free%";
            free_ram = PlaceholderAPI.setPlaceholders(player,free_ram);
            String ram = args[0];
            switch (ram) {
                case "used":
                    player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "当前服务器已用内存：" + ChatColor.GREEN + used_ram);
                    break;
                case "free":
                    player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "当前服务器剩余内存：" + ChatColor.GREEN + free_ram);
            }
        }else {
            System.out.println(ChatColor.RED + "Error: Please let the player execute the command");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("used");
            list.add("free");
            return list;
        }
        return null;
    }
}
