package top.huanmeng.Commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getServer;

public class InventorySearch implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")){
            if (command.getName().equalsIgnoreCase("search")){
                if (args.length > 1){
                    Player target = getServer().getPlayer(args[0]);
                    if (target != null){
                        Material material = Material.matchMaterial(args[1]);
                        if (material != null){
                            ItemStack[] contents = target.getInventory().getContents();
                            for (ItemStack item : contents){
                                if (item != null && item.getType() == material){
                                    sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.RESET + target.getName() + " 的背包中有 " + material.name() + "!");
                                    return true;
                                }
                            }
                            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.RESET + target.getName() + " 的背包中没有 " + material.name() + "!");
                        }else {
                            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.RESET + "无效的物品名: " + ChatColor.GREEN + args[1]);
                        }
                    }else {
                        sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.RESET + "找不到该玩家: " + ChatColor.GREEN + args[0]);
                    }
                }else {
                    sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.RED + "用法: /search <player> <item>");
                }
                return true;
            }
        }else if (sender instanceof ConsoleCommandSender){
            System.out.println(org.bukkit.ChatColor.RED + "Error: Please let the player execute the command");
        }
        return false;
    }
}