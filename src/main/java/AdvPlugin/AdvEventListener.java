package AdvPlugin;

import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class AdvEventListener implements Listener 
{
	private final AdvPlugin calledplugin;
    public AdvEventListener(AdvPlugin plugin) //constructor sets up a listener on server events
    {
    	calledplugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void login(PlayerLoginEvent event) //Player logs on
    {
    	event.getPlayer().sendMessage("Welcome!");
        calledplugin.playerlist.add(event.getPlayer());
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void logout(PlayerQuitEvent event)// player leaves
    {
    	Player player = event.getPlayer();
    		if(calledplugin.playerlist.contains(player))
    		{
    			calledplugin.playerlist.remove(player);
    			if(calledplugin.AdvPlayersList.contains(player))
    			{
    				calledplugin.AdvPlayersList.remove(player);
    			}
    		}
    	
    }

   
}