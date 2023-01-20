package huanmeng.mengpluginx.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class MengPluginXCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "Plugin is running(ᗒᗩᗕ)՞");
            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "If the ping and TPS commands do not work, enter the papi ecloud download Player and papi ecloud download Server commands to download the PAPI dependencies and restart PAPI");
        } else if (sender instanceof ConsoleCommandSender) {
            System.out.println(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "Plugin is running");
            System.out.println(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "If the ping and TPS commands do not work, enter the papi ecloud download Player and papi ecloud download Server commands to download the PAPI dependencies and restart PAPI");
        }
        return false;
    }
}
