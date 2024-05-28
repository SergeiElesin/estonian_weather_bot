package com.elesin.estonian_weather_bot.client;

import com.elesin.estonian_weather_bot.exception.ServiceException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WeatherClient {

    @Autowired
    private OkHttpClient httpClient;

    @Value("${estonian.weather.xml.url}")
    private String url;

    public String getWeatherXml() throws ServiceException {
        var request = new Request.Builder()
                .url(url)
                .build();

        try (var response = httpClient.newCall(request).execute()) {
            var body = response.body();
            return body == null ? null : body.string();
        } catch (IOException e){
            throw new ServiceException("Data Retrieval Error", e);
        }
    }
}
