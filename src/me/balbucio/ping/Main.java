package me.balbucio.ping;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Main extends Plugin {
	private static Main instance;
	private File file = new File("plugins/balbPing", "config.yml");
	private Configuration config;
	
	public void onEnable() {
		setInstance(this);
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new Ping());
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new PingReport());
		BungeeCord.getInstance().getConsole().sendMessage(new TextComponent("[BalbucioPing] §2Ativado com sucesso!"));
	}

	private void load(){
		try {
			if (!file.exists()) {
				Files.copy(this.getClass().getResourceAsStream("/config.yml"), file.toPath());
			}
			config = YamlConfiguration.getProvider(YamlConfiguration.class).load(file);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	   public static Main getInstance() {
	        return instance;
	    }

	    private static void setInstance(final Main instance) {
	        Main.instance = instance;
	    }
}
