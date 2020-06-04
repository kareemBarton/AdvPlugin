package AdvPlugin;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public class AdvPlugin extends JavaPlugin
{
	List <Player> playerlist = new ArrayList<Player>();//online players
	List <Player> AdvPlayersList = new ArrayList<Player>();//online players who have joined the event
	Boolean event = false;
	World adventureWorld = this.getServer().getWorld("AdventureWorld");
	Location group1 = new Location(this.getServer().getWorld("AdventureWorld"),0,200,0);
	Location group2 = new Location(this.getServer().getWorld("AdventureWorld"),0,200,0);
	Location group3 = new Location(this.getServer().getWorld("AdventureWorld"),0,200,0);
	Location group4 = new Location(this.getServer().getWorld("AdventureWorld"),0,200,0);
	@Override
	public void onEnable()
	{
		getLogger().info("The AdvPlugin is being enabled!");
		this.getServer().getPluginManager().registerEvents(new AdvEventListener(this),this);
		this.getCommand("setGroup").setExecutor(new AdvCommandExecutor(this));
		this.getCommand("setRank").setExecutor(new AdvCommandExecutor(this));
		this.getCommand("joinAdv").setExecutor(new AdvCommandExecutor(this));
		this.getCommand("createGame").setExecutor(new AdvCommandExecutor(this));
		this.getCommand("destroyGame").setExecutor(new AdvCommandExecutor(this));
		this.getCommand("leaveAdv").setExecutor(new AdvCommandExecutor(this));
		this.getCommand("setGroupHome").setExecutor(new AdvCommandExecutor(this));
		this.getCommand("startGame").setExecutor(new AdvCommandExecutor(this));
		for (Player player : Bukkit.getServer().getOnlinePlayers()) 
		{	
		    playerlist.add(player); 
		}
		
	
	}
	public void onDisable()
	{
		getLogger().info("The Advplugin is being disabled!");
	}
}
