package com.isetrip.najebstu.commands;

import com.isetrip.jbotify.commands.CommandBase;
import com.isetrip.jbotify.managers.LangManager;
import com.isetrip.jbotify.utils.LangUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.WebAppInfo;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Random;

@Slf4j
public class StartCommand implements CommandBase {

    @Override
    public String getName() {
        return "start";
    }

    @Override
    public String getDescription(String lang) {
        return LangUtils.get(lang, "startDescription");
    }

    @Override
    public boolean canExecute(String chatId) {
        return false;
    }

    @Override
    public void process(Update update, TelegramBot bot) {
        String langFile = LangManager.getInstance().getLangFile(update.message().from().languageCode());
        WebAppInfo webAppInfo = new WebAppInfo("https://isetrip.github.io/WebApps/njb/rules.html?lang=" + langFile);
        InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                new InlineKeyboardButton(LangUtils.get(update.message().from().languageCode(), "readRules")).webApp(webAppInfo));
        SendMessage sendMessage = new SendMessage(update.message().chat().id(), LangUtils.get(update.message().from().languageCode(), "rulesMessage"))
            .replyMarkup(inlineKeyboard);
        bot.execute(sendMessage);

        webAppInfo = new WebAppInfo("https://isetrip.github.io/WebApps/njb/apply.html?lang=" + langFile);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(
                new KeyboardButton(LangUtils.get(update.message().from().languageCode(), "list")).webAppInfo(webAppInfo));
        sendMessage = new SendMessage(update.message().chat().id(), LangUtils.get(update.message().from().languageCode(), "listMessage"))
                .replyMarkup(replyKeyboardMarkup.resizeKeyboard(true).isPersistent(true).oneTimeKeyboard(false));
        bot.execute(sendMessage);
    }

}
