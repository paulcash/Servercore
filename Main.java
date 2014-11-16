package main;

import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.player.AsyncPlayerChatEvent;


@Plugin(id = "Randomid", name = "ServerCore-Events", version="0.1")
public class Main {

	@Subscribe
	public void onChatEvent(AsyncPlayerChatEvent event) {
		String message = event.getMessage();
		Player player = event.getPlayer();
		
		if(message.equalsIgnoreCase("Hello")) {
			player.sendMessage("Hello");
		} else if(message.contains("How do I get to the nether?")) {
			player.sendMessage("Hello" + player.getName() + "! You need obsidian to build a nether portal! Mine to get obsidian!");
		}
		
		/* Append more else-if-statements here. */
	}
}
