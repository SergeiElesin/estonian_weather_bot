package com.elesin.estonian_weather_bot.configuration;

import com.elesin.estonian_weather_bot.bot.EstonianWeatherBot;
import okhttp3.OkHttpClient;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@EnableCaching
@EnableScheduling
public class EstonianWeatherBotConfiguration {


    //Registering bot
    @Bean
    public TelegramBotsApi telegramBotsApi(EstonianWeatherBot estonianWeatherBot) throws TelegramApiException {
        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(estonianWeatherBot);
        return api;
    }

    //Bean fot Http-request library
    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
