package me.NinetyNine.gccl;

import org.bukkit.plugin.java.JavaPlugin;

import me.NinetyNine.gccl.commands.GCCLCommands;

public class GCCL extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("changelog").setExecutor(new GCCLCommands());
		getCommand("gcchangelog").setExecutor(new GCCLCommands());
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();
	}
	
	@Override
	public void onDisable() {
		
	}

}
