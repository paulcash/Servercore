package com.paulcarter.servercore.chat;

import org.spongepowered.api.event.player.PlayerChatEvent;

public interface ChatBehaviour {

    public boolean handleEvent(PlayerChatEvent event);

}
