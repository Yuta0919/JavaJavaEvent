package javajava.javajavaevent;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PassEnter implements CommandExecutor {
    public static int pass;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        pass = JavaJavaEvent.plugin.getConfig().getInt("Pass");
        if (args[0].equals(String.valueOf(pass))) {
            int a = JavaJavaEvent.joincount.get(sender.getName());
            if (a == 0) {
                JavaJavaEvent.joincount.put(sender.getName(), 1);
                sender.sendMessage(ChatColor.RED + "制限を解除しました");
                Player p = (Player) sender;
                p.setGameMode(GameMode.SURVIVAL);
                JavaJavaEvent.joinname = JavaJavaEvent.joinname + sender.getName();
            }
        } else {
            sender.sendMessage(ChatColor.RED + "正しいパスワードを打ってください");
        }
        return true;
    }
}
