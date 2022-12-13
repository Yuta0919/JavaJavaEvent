package javajava.javajavaevent;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class PassChange implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp()){
            PassEnter.pass= Integer.parseInt(args[0]);
            JavaJavaEvent.plugin.getConfig().set("Pass", PassEnter.pass);
            JavaJavaEvent.plugin.saveConfig();
        }
        return true;
    }
}
