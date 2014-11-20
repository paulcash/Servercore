package com.paulcarter.servercore.chat;

import com.paulcarter.servercore.Reference;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.player.PlayerChatEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;
import java.util.List;

public class ChatManager {

    private Logger logger = LogManager.getLogger(Reference.PLUGINID + "-chat");

    private List<ChatBehaviour> behaviours;

    public void processEvent(PlayerChatEvent event) {
        for (ChatBehaviour behaviour : behaviours) {
            if (behaviour.handleEvent(event)) {
                if (event.isCancellable()) { ((Cancellable) event).setCancelled(true); }
                logger.debug("Event {} was handled by ChatBehaviour {}.", event, behaviour);
                return;
            }
        }
    }

    public void register(ChatBehaviour behaviour) {
        behaviours.add(behaviour);
    }

    public void unregister(ChatBehaviour behaviour) {
        behaviours.remove(behaviour);
    }

}
