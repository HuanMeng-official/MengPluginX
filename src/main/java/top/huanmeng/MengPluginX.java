package top.huanmeng;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import top.huanmeng.Commands.*;
import top.huanmeng.PlaceholderAPI.*;
import top.huanmeng.Events.*;
import top.huanmeng.Tools.*;
import top.huanmeng.Words.*;
import top.huanmeng.Worlds.*;

import java.util.Objects;

public final class MengPluginX extends JavaPlugin {

    @Override
    public void onLoad() {
        System.out.println(ChatColor.GOLD + "__  __ ______  __");
        System.out.println(ChatColor.GOLD + "|  \\/  |  _ \\ \\/ /");
        System.out.println(ChatColor.GOLD + "| |\\/| | |_)  \\  /");
        System.out.println(ChatColor.GOLD + "| |  | |  __/ /  \\");
        System.out.println(ChatColor.GOLD + "|_|  |_|_|  /_/\\_\\");
    }

    @Override
    public void onEnable() {
        System.out.println("插件成功加载");
        boolean keepInventory = getConfig().getBoolean("KeepInventory", true);
        if (keepInventory){
            System.out.println(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.RESET + "功能“KeepInventory”已开启");
        }else {
            System.out.println(ChatColor.YELLOW + "[幻梦娘]" + ChatColor.RESET + "功能“KeepInventory”未开启");
        }
        int pluginId = 18219;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
        getServer().getScheduler().scheduleSyncDelayedTask(this,new TickPerSecond(),100L);
        saveResource("keywords.yml",false);
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayerBedEnterEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayerBedLeaveEvent(),this);
        getServer().getPluginManager().registerEvents(new BadWords(),this);
        getServer().getPluginManager().registerEvents(new KeepInventory(),this);
        Objects.requireNonNull(getCommand("mpx")).setExecutor(new MengPluginXInfo());
        Objects.requireNonNull(getCommand("gm")).setExecutor(new SetGameMode());
        Objects.requireNonNull(getCommand("mpx_tps")).setExecutor(new GetTickPerSecond());
        Objects.requireNonNull(getCommand("mpx_ping")).setExecutor(new GetPlayerPing());
        Objects.requireNonNull(getCommand("online_player")).setExecutor(new GetOnlinePlayer());
        Objects.requireNonNull(getCommand("mpx_seed")).setExecutor(new GetWorldSeed());
        Objects.requireNonNull(getCommand("mpx_time")).setExecutor(new GetFullTime());
        Objects.requireNonNull(getCommand("mpx_uuid")).setExecutor(new GetPlayerUUID());
        Objects.requireNonNull(getCommand("mpx_ip")).setExecutor(new GetPlayerIP());
        Objects.requireNonNull(getCommand("mpx_sa")).setExecutor(new SendAnnouncement());
        Objects.requireNonNull(getCommand("mpx_ram")).setExecutor(new GetServerRam());
    }

    @Override
    public void onDisable() {
        System.out.println("插件成功关闭");
    }
}