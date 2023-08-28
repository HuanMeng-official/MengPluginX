package top.huanmeng.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HolographicText implements CommandExecutor , TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")){
            Player player = (Player) sender;
            ArmorStand entity = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            String text = String.join(" ", args);
            if (text.length() > 1){
                entity.setCustomName(ChatColor.translateAlternateColorCodes('&', text));
            }else {
                entity.setCustomName("MengPluginX");
            }
            entity.setCustomNameVisible(true);
            entity.setVisible(false);
            entity.setGravity(false);
            return true;
        }else if (sender instanceof  ConsoleCommandSender) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            consoleCommandSender.sendMessage(ChatColor.RED + "Error: Please let the op execute the command");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length > 1){
            List<String> list = new ArrayList<>();
            list.add("<text>");
            return list;
        }
        return null;
    }
}
