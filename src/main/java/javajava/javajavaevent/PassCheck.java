package javajava.javajavaevent;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PassCheck implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp()){
            sender.sendMessage(ChatColor.RED+"今のパスワードは"+ JavaJavaEvent.plugin.getConfig().getInt("Pass")+"です");
        }
        return true;
    }
}
