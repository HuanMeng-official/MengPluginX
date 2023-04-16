package top.huanmeng;

import org.bukkit.plugin.java.JavaPlugin;
import top.huanmeng.Commands.*;
import top.huanmeng.PlaceholderAPI.*;
import top.huanmeng.PlayerEvents.*;
import top.huanmeng.Tools.*;
import top.huanmeng.Words.*;
import top.huanmeng.Worlds.*;

import java.util.Objects;

public final class MengPluginX extends JavaPlugin {

    @Override
    public void onLoad() {
        System.out.println("插件正在加载");
    }

    @Override
    public void onEnable() {
        System.out.println("插件成功加载");
        getServer().getScheduler().scheduleSyncDelayedTask(this,new TickPerSecond(),100L);
        saveResource("keywords.yml",false);
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new PlayerJoinEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayerBedEnterEvent(),this);
        getServer().getPluginManager().registerEvents(new PlayerBedLeaveEvent(),this);
        getServer().getPluginManager().registerEvents(new BadWords(),this);
        Objects.requireNonNull(getCommand("mpx")).setExecutor(new MengPluginXCommands());
        Objects.requireNonNull(getCommand("mpx_help")).setExecutor(new CommandHelp());
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