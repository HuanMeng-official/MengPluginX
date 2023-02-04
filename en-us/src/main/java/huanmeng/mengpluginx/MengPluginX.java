package huanmeng.mengpluginx;

import huanmeng.mengpluginx.Commands.*;
import huanmeng.mengpluginx.PlayerEvents.*;
import huanmeng.mengpluginx.PlaceholderAPI.*;
import huanmeng.mengpluginx.Words.*;
import huanmeng.mengpluginx.Worlds.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MengPluginX extends JavaPlugin {

    @Override
    public void onLoad() {
        System.out.println(ChatColor.GREEN + "===================");
        System.out.println("The plugin is loading...");
        System.out.println("Loading config.yml");
        System.out.println("Loading keywords.yml");
        System.out.println("version: 2.0-r8");
        System.out.println("author: HuanMeng_");
        System.out.println(ChatColor.GREEN + "===================");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("The Plugin is loaded successfully");
        saveResource("keywords.yml",false);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayerBedEnterEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayerBedLeaveEvent(),this);
        getServer().getPluginManager().registerEvents(new BadWords(),this);
        Objects.requireNonNull(getCommand("mpx")).setExecutor(new MengPluginXCommands());
        Objects.requireNonNull(getCommand("gm")).setExecutor(new SetGameMode());
        Objects.requireNonNull(getCommand("gm")).setTabCompleter(new SetGameMode());
        Objects.requireNonNull(getCommand("mpx_tps")).setExecutor(new GetServerTPS());
        Objects.requireNonNull(getCommand("mpx_ping")).setExecutor(new GetPlayerPing());
        Objects.requireNonNull(getCommand("online_player")).setExecutor(new GetOnlinePlayer());
        Objects.requireNonNull(getCommand("mpx_seed")).setExecutor(new GetWorldSeed());
        Objects.requireNonNull(getCommand("mpx_time")).setExecutor(new GetFullTime());
        Objects.requireNonNull(getCommand("mpx_uuid")).setExecutor(new GetPlayerUUID());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("The plugin is stopping...");
    }
}
