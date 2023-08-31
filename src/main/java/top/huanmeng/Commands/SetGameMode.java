package top.huanmeng.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static top.huanmeng.MengPluginX.m;

public class SetGameMode implements CommandExecutor , TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")){
            Player player = (Player) sender;
            String mode = args[0];
            switch (mode) {
                case "1":
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(m + ChatColor.RESET + "已将您的游戏模式更换为创造");
                    break;
                case "2":
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(m + ChatColor.RESET + "已将您的游戏模式更换为冒险");
                    break;
                case "3":
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(m + ChatColor.RESET + "已将您的游戏模式更换为旁观");
                    break;
                case "0":
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(m + ChatColor.RESET + "已将您的游戏模式更换为生存");
                    break;
            }
        } else if (sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender consoleCommandSender = (ConsoleCommandSender) sender;
            consoleCommandSender.sendMessage(ChatColor.RED + "Error: Please let the op execute the command");
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            list.add("2");
            list.add("3");
            return list;
        }
        return null;
    }
}
