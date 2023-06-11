package com.isetrip.najebstu.handlers;

import com.isetrip.jbotify.annotations.BotEventHandler;
import com.isetrip.jbotify.events.elements.LanguagesRegistryEvent;
import com.isetrip.jbotify.events.elements.WebAppDataReceiveEvent;

@BotEventHandler
public class EventHandler {

    @BotEventHandler.Listener
    public void registerLangs(LanguagesRegistryEvent event) {
        event.register("uk", "ua_UK");
    }

    @BotEventHandler.Listener
    public void onWebDataReceive(WebAppDataReceiveEvent event) {

    }

}
