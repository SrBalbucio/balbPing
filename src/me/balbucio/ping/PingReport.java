package me.balbucio.ping;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingReport extends Command{

	public PingReport() {
		super("pingreport");
	}
	public void execute(CommandSender sender, String[] args) {
		if(sender.hasPermission("bpingreport.use")) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p =(ProxiedPlayer)sender;
			p.sendMessage(new TextComponent(Main.getInstance().msg_2));
			for(ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				if(all.hasPermission("bping.view")) {
					all.sendMessage(new TextComponent("§f[Ping] "+Main.getInstance().msg_3));
					all.sendMessage(new TextComponent("§f[Ping] §b§lPlayer: §e§l"+sender.getName()+" §b§lPing: §e§l"+p.getPing()+"ms."));
				}
				}
		}
		}
	}

}
