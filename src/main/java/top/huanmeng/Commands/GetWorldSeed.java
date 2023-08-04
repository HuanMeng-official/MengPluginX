package top.huanmeng.Commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
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
            player.sendMessage(m + ChatColor.RESET + "种子：" + ChatColor.GREEN + seed);
            return true;
        }else if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            consoleCommandSender.sendMessage(ChatColor.RED + "Error: Please let the op execute the command");
        }
        return false;
    }
}
