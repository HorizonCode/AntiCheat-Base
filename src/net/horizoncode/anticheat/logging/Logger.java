package net.horizoncode.anticheat.logging;

import org.bukkit.plugin.Plugin;

public class Logger {
	
	public String name;
	public Plugin pl;
	
	public Logger(Plugin p){
		this.name = p.getName();
		this.pl = p;
	}
	
	public void log(String s){
		pl.getServer().getConsoleSender().sendMessage("[" + name + "] | [INFO] " + s);
	}
	
	public void log(String s, LogType type){
		pl.getServer().getConsoleSender().sendMessage("[" + name + "] | [" + type.name() + "] " + s);
	}
	
	public enum LogType{
		INFO, WARNING, ERROR
	}
}
