package top.huanmeng.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getServer;
import static top.huanmeng.MengPluginX.m;

public class InventorySearch implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")){
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("search")){
                if (args.length > 1){
                    Player target = getServer().getPlayer(args[0]);
                    if (target != null){
                        Material material = Material.matchMaterial(args[1]);
                        if (material != null){
                            ItemStack[] contents = target.getInventory().getContents();
                            for (ItemStack item : contents){
                                if (item != null && item.getType() == material){
                                    player.sendMessage(m + ChatColor.RESET + target.getName() + " 的背包中有 " + material.name() + "!");
                                    return true;
                                }
                            }
                            player.sendMessage(m + ChatColor.RESET + target.getName() + " 的背包中没有 " + material.name() + "!");
                        }else {
                            player.sendMessage(m + ChatColor.RESET + "无效的物品名: " + ChatColor.GREEN + args[1]);
                        }
                    }else {
                        player.sendMessage(m + ChatColor.RESET + "找不到该玩家: " + ChatColor.GREEN + args[0]);
                    }
                }else {
                    player.sendMessage(m + ChatColor.RED + "用法: /search <player> <item>");
                }
                return true;
            }
        }else if (sender instanceof  ConsoleCommandSender) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            consoleCommandSender.sendMessage(ChatColor.RED + "Error: Please let the op execute the command");
        }
        return false;
    }
}