package top.huanmeng;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import top.huanmeng.Commands.*;
import top.huanmeng.PlaceholderAPI.*;
import top.huanmeng.Events.*;
import top.huanmeng.Tools.*;
import top.huanmeng.Words.*;
import top.huanmeng.Worlds.*;

import java.util.Objects;
import java.util.logging.Logger;

public final class MengPluginX extends JavaPlugin {

    public static String m = ChatColor.YELLOW + "[幻梦娘]";
    public static Logger logger = Bukkit.getLogger();
    @Override
    public void onLoad() {
        logger.info(ChatColor.DARK_RED + "MengPluginX is loading");
    }

    @Override
    public void onEnable() {
        logger.info(ChatColor.DARK_GREEN + "=========================");
        logger.info(ChatColor.GOLD + "__  __ ______  __");
        logger.info(ChatColor.GOLD + "|  \\/  |  _ \\ \\/ /");
        logger.info(ChatColor.GOLD + "| |\\/| | |_)  \\  /");
        logger.info(ChatColor.GOLD + "| |  | |  __/ /  \\");
        logger.info(ChatColor.GOLD + "|_|  |_|_|  /_/\\_\\");
        int pluginId = 18219;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
        saveResource("keywords.yml",false);
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayerQuitEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayerBedEnterEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayerBedLeaveEvent(),this);
        getServer().getPluginManager().registerEvents(new BadWords(),this);
        getServer().getPluginManager().registerEvents(new KeepInventory(),this);
        getServer().getPluginManager().registerEvents(new AntiCreeper(),this);
        getServer().getPluginManager().registerEvents(new AntiEnderMan(),this);
        Objects.requireNonNull(getCommand("mpx")).setExecutor(new CommandHelp());
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
        Objects.requireNonNull(getCommand("search")).setExecutor(new InventorySearch());
        Objects.requireNonNull(getCommand("mpx_text")).setExecutor(new HolographicText());
        boolean badwords = getConfig().getBoolean("BadWords",true);
        boolean keepInventory = getConfig().getBoolean("KeepInventory", true);
        boolean antiCreeper = getConfig().getBoolean("AntiCreeper",true);
        boolean antiEnderMan = getConfig().getBoolean("AntiEnderMan",true);
        if (badwords){
            logger.info(m + ChatColor.RESET + "功能“BadWords”已开启");
        }else {
            logger.info(m + ChatColor.RESET + "功能“BadWords”未开启");
        }
        if (keepInventory){
            logger.info(m + ChatColor.RESET + "功能“KeepInventory”已开启");
        }else {
            getLogger().info(m + ChatColor.RESET + "功能“KeepInventory”未开启");
        }
        if (antiCreeper){
            logger.info(m + ChatColor.RESET + "功能“AntiCreeperBoom”已开启");
        }else {
            logger.info(m + ChatColor.RESET + "功能“AntiCreeperBoom”未开启");
        }
        if (antiEnderMan){
            logger.info(m + ChatColor.RESET + "功能“AntiEnderManPickupBlock”已开启");
        }else {
            logger.info(m + ChatColor.RESET + "功能“AntiEnderManPickupBloc”未开启");
        }
        logger.info(ChatColor.DARK_GREEN + "=========================");
    }

    @Override
    public void onDisable() {
        logger.info(ChatColor.DARK_RED + "MengPluginX is disabled");
    }
}