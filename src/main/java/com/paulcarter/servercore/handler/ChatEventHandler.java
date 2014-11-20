package com.paulcarter.servercore.handler;

import com.paulcarter.servercore.ServerCore;
import com.paulcarter.servercore.chat.ChatManager;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.player.PlayerChatEvent;

public class ChatEventHandler {

    @Subscribe
    public void onChatEvent(PlayerChatEvent event) {
        ServerCore.getInstance().chatManager.processEvent(event);
    }

}
