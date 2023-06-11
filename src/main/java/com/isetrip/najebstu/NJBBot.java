package com.isetrip.najebstu;

import com.isetrip.jbotify.JBotifyApplication;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class NJBBot {

    public static void main(String... args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JBotifyApplication.run(NJBBot.class, args);
    }
}
