package javajava.javajavaevent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class JavaJavaEvent extends JavaPlugin implements Listener {
public static HashMap<String,Integer> joincount =new HashMap<>();
public static JavaPlugin plugin;
public static String joinname;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        PassEnter.pass= getConfig().getInt("Pass");
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("password").setExecutor(new PassEnter());
        getCommand("passchange").setExecutor(new PassChange());
        getCommand("passcheck").setExecutor(new PassCheck());
        plugin=this;
    }

    @Override
    public void onDisable() {
        JavaJavaEvent.plugin.getConfig().set("JoinName", joinname);
        JavaJavaEvent.plugin.saveConfig();
        // Plugin shutdown logic
    }
    @EventHandler
    public static void onMoveEvent(PlayerMoveEvent e){
        if(joincount.get(e.getPlayer().getName())==0){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED+"パスワードを入力してください。\n" +
                    "/pass XXOO\n" +
                    "xxは【はじめに】\n" +
                    "OOは【各イベントページ】\n" +
                    "からご確認ください。\n");
        }
    }
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent e){
        if(!(joincount.containsKey(e.getPlayer().getName()))){
            joincount.put(e.getPlayer().getName(), 0);
            e.getPlayer().setGameMode(GameMode.SPECTATOR);
            e.getPlayer().sendMessage(ChatColor.RED+"パスワードを入力してください。\n" +
                    "/pass XXOO\n" +
                    "xxは【はじめに】\n" +
                    "OOは【各イベントページ】\n" +
                    "からご確認ください。\n");
        }
    }
    @EventHandler
    public static void onPlayerChat(PlayerChatEvent e) {
        if (joincount.get(e.getPlayer().getName()) == 0) {
            e.setCancelled(true);
            Bukkit.getPlayer("Yuta0919").sendMessage(ChatColor.RED+"(パスワード未入力)<" + e.getPlayer().getName() + ">" + e.getMessage());
            Bukkit.getPlayer("az_aka").sendMessage(ChatColor.RED+"(パスワード未入力)<" + e.getPlayer().getName() + ">" + e.getMessage());
            Bukkit.getPlayer("az__ao").sendMessage(ChatColor.RED+"(パスワード未入力)<" + e.getPlayer().getName() + ">" + e.getMessage());
        }
    }
}
