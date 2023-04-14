package me.balbucio.ping;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Ping extends Command{
	
	public Ping() {
		super("ping");
	}
	public void execute(CommandSender sender, String[] args) {
		if (args.length == 0) {
			if (sender instanceof ProxiedPlayer) {
				ProxiedPlayer p = (ProxiedPlayer) sender;
				p.sendMessage(new TextComponent(Main.getInstance().con + p.getPing() + "�fms."));
			} else {
				sender.sendMessage(new TextComponent("[balbPing] �cSomente players podem usar esse comando."));
			}
		}
		if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
			if (sender.hasPermission("bping.list")) {
				for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
					sender.sendMessage(new TextComponent(all.getName() + " �e�l> " + all.getPing()));
				}
			}
		}
		if (args.length == 1 && !args[0].equalsIgnoreCase("list")) {
			if (sender.hasPermission("bping.other")) {
				ProxiedPlayer player = BungeeCord.getInstance().getPlayer(args[0]);
				sender.sendMessage(new TextComponent("�b�lPing do Player: �f" + player.getPing() + " ms."));
			}
		}
	}

}
