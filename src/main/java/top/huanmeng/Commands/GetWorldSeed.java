package top.huanmeng.Commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static top.huanmeng.MengPluginX.m;

public class GetWorldSeed implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            World world = player.getWorld();
            long seed = world.getSeed();
            sender.sendMessage(m + ChatColor.RESET + "种子：" + ChatColor.GREEN + seed);
            return true;
        }else {
            System.out.println(ChatColor.RED + "Error: Please let the player execute the command");
            return false;
        }
    }
}
