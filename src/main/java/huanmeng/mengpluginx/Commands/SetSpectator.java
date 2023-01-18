package huanmeng.mengpluginx.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpectator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("mpx.huanmeng.op")){
            Player player = (Player) sender;
            ((Player) sender).setGameMode(GameMode.SPECTATOR);
            player.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "已将您的游戏模式更换为旁观");
        }else{
            System.out.println(ChatColor.RED + "Error: Please let the player execute the command");
        }
        return false;
    }
}