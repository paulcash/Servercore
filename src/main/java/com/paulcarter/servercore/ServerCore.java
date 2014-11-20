package com.paulcarter.servercore;

import com.paulcarter.servercore.chat.ChatBehaviour;
import com.paulcarter.servercore.chat.ChatManager;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Subscribe;
import org.spongepowered.api.event.player.PlayerChatEvent;
import org.spongepowered.api.event.state.InitializationEvent;
import org.spongepowered.api.event.state.ServerStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Plugin(id = Reference.PLUGINID, name = Reference.NAME, version = Reference.VERSION)
public class ServerCore {

    private static ServerCore INSTANCE;


    public Game game;

    public Logger logger = LogManager.getLogger(Reference.PLUGINID);

    public ChatManager chatManager = new ChatManager();

    public static ServerCore getInstance() {
        return INSTANCE;
    }

    @Subscribe
    public void onInitialization(InitializationEvent event) {
        INSTANCE = this;
        game = event.getGame();

        //Register ChatBehaviours

        chatManager.register(
          new ChatBehaviour() {

              @Override
              public boolean handleEvent(PlayerChatEvent event) {
                  if (event.getMessage().equalsIgnoreCase("hello")) {
                      event.getPlayer().sendMessage(String.format("Hello, %s", event.getPlayer().getName()));
                      return true;
                  }
                  return false;
              }
          }
        );

        chatManager.register(
          new ChatBehaviour() {

              @Override
              public boolean handleEvent(PlayerChatEvent event) {
                  if (event.getMessage().contains("How do I get to the nether?")) {
                      event.getPlayer().sendMessage(
                        String.format("Hello %s! You need obsidian to build a nether portal! Mine to get obsidian!", event.getPlayer().getName())
                      );
                      return true;
                  }
                  return false;
              }
          }
        );

        chatManager.register(
          new ChatBehaviour() {

              @Override
              public boolean handleEvent(PlayerChatEvent event) {
                  if (event.getMessage().equalsIgnoreCase("hello")) {
                      event.getPlayer().sendMessage(String.format("Hello, %s", event.getPlayer().getName()));
                      return true;
                  }
                  return false;
              }
          }
        );

        chatManager.register(
          new ChatBehaviour() {

              @Override
              public boolean handleEvent(PlayerChatEvent event) {
                  if (event.getMessage().contains("help")) {
                      for (String message : Reference.helpStrings) {
                          event.getPlayer().sendMessage(String.format(message, event.getPlayer()));
                      }
                      return true;
                  }
                  return false;
              }
          }
        );
    }

    @Subscribe
    public void onServerStopping(ServerStoppingEvent event) {

    }

}
