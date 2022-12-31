package huanmeng.mengpluginx.Commands;

import org.bukkit.ChatColor;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;

import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

public class MengPluginXCommands implements CommandExecutor {

    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            sender.sendMessage(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.WHITE + "插件已启用了哦(ᗒᗩᗕ)՞");

        }else{

            System.out.println("Error: Please let the player execute the command");

        }

        return false;

    }

}
