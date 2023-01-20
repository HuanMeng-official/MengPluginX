package huanmeng.mengpluginx.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetGameMode implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")){
            Player player = (Player) sender;
            String mode = args[0];
            switch (mode) {
                case "1":
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "已将您的游戏模式更换为创造");
                    break;
                case "2":
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "已将您的游戏模式更换为冒险");
                    break;
                case "3":
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "已将您的游戏模式更换为旁观");
                    break;
                case "0":
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "已将您的游戏模式更换为生存");
                    break;
            }
        }else {
            System.out.println(ChatColor.RED + "Error: Please let the player execute the command");
        }
        return false;
    }
}
