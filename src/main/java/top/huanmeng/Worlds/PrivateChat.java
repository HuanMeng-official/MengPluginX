package top.huanmeng.Worlds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static top.huanmeng.MengPluginX.m;

public class PrivateChat implements Listener , CommandExecutor {
    public static HashMap<Player, Player> privateChats = new HashMap<>();
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player sender = event.getPlayer();
        Player receiver = privateChats.get(sender);
        if (receiver != null) {
            String message = event.getMessage();
            receiver.sendMessage(m + ChatColor.DARK_RED + "[私聊]" + ChatColor.AQUA + sender.getName() + ChatColor.RESET + message);
            sender.sendMessage(m + ChatColor.DARK_RED + "[私聊]" + ChatColor.AQUA + sender.getName() + ChatColor.RESET + message);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (privateChats.containsKey(player)) {
            Player target = privateChats.get(player);
            privateChats.remove(player);
            target.sendMessage(m + ChatColor.GREEN + player.getName() + ChatColor.RESET + "已经退出了服务器，你已经停止和他私聊了");
        }
        if (privateChats.containsValue(player)) {
            Player target = null;
            for (Map.Entry<Player, Player> entry : privateChats.entrySet()) {
                if (entry.getValue() == player) {
                    target = entry.getKey();
                    break;
                }
            }
            if (target != null) {
                privateChats.remove(target);
                target.sendMessage(m + ChatColor.GREEN + player.getName() + ChatColor.RESET + "已经退出了服务器，你已经停止和他私聊了");
            }
        }
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        // 玩家执行命令时触发这个方法
        if (command.getName().equalsIgnoreCase("mpx_private")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    String targetName = args[0];
                    if (targetName.equalsIgnoreCase("stop")) {
                        if (privateChats.containsKey(player)) {
                            Player target = privateChats.get(player);
                            privateChats.remove(player);
                            player.sendMessage(m + ChatColor.GREEN + "你已经停止和" + target.getName() + "私聊了");
                            target.sendMessage(m + ChatColor.GREEN + player.getName() + "已经停止和你私聊了");
                        } else {
                            player.sendMessage(m + ChatColor.RED + "你没有和任何人私聊，输入/mpx_private <玩家名>来开始私聊");
                        }
                    } else {
                        Player target = Bukkit.getPlayer(targetName);
                        if (target != null) {
                            if (target != player) {
                                privateChats.put(player, target);
                                player.sendMessage(m + ChatColor.GREEN + "你已经开始和" + target.getName() + "私聊了，输入/mpx_private stop来停止私聊");
                                target.sendMessage(m + ChatColor.GREEN + player.getName() + "已经开始和你私聊了，输入/mpx_private stop来停止私聊");
                            } else {
                                player.sendMessage(m + ChatColor.RED + "你不能和自己私聊");
                            }
                        } else {
                            player.sendMessage(m + ChatColor.RED + "找不到玩家" + targetName);
                        }
                    }
                } else if (args.length == 0) {
                    player.sendMessage(m + ChatColor.RED + "命令格式错误，正确的格式是/mpx_private <玩家名>或者/mpx_private stop");
                } else {
                    player.sendMessage(m + ChatColor.RED + "命令格式错误，正确的格式是/mpx_private <玩家名>或者/mpx_private stop");
                }
            } else {
                sender.sendMessage(m + ChatColor.RED + "只有玩家才能使用这个命令");
            }
            return true;
        }
        return false;
    }
}