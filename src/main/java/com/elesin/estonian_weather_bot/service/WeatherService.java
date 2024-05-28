package com.elesin.estonian_weather_bot.service;

import com.elesin.estonian_weather_bot.exception.ServiceException;

public interface WeatherService {

    String getWeatherKuressaare() throws ServiceException;
    String getWeatherTallinn() throws ServiceException;
    String getWeatherKunda() throws ServiceException;
    String getWeatherJohvi() throws ServiceException;
    String getWeatherNarva() throws ServiceException;
    String getWeatherVaikeMaarja() throws ServiceException;
    String getWeatherJogeva() throws ServiceException;
    String getWeatherTartu() throws ServiceException;
    String getWeatherVoru() throws ServiceException;
    String getWeatherValga() throws ServiceException;
    String getWeatherViljandi() throws ServiceException;
    String getWeatherKihnu() throws ServiceException;
    String getWeatherHaapsalu() throws ServiceException;
    String getWeatherPaldiski() throws ServiceException;
    String getWeatherParnu() throws ServiceException;
    String getWeatherNarvaJoesuu() throws ServiceException;
    String getWeatherPirita() throws ServiceException;
    String getWeatherLoksa() throws ServiceException;
    String getWeatherKehra() throws ServiceException;
    String getWeatherRapina() throws ServiceException;
    String getWeatherToila() throws ServiceException;
    String getWeatherKeila () throws ServiceException;
    String getWeatherMustvee() throws ServiceException;
    String getWeatherOtepaa() throws ServiceException;

    void clearKURESSAARECache();
    void clearTALLINNCache();
    void clearKUNDACache();
    void clearJOHVICache();
    void clearNARVACache();
    void clearVAIKEMARJACache();
    void clearJOGEVACache();
    void clearTARTUCache();
    void clearVORUCache();
    void clearVALGACache();
    void clearVILJANDICache();
    void clearKIHNUCache();
    void clearHAAPSALUCache();
    void clearPALDISKICache();
    void clearPARNUCache();
    void clearNARVAJOESUUCache();
    void clearPIRITACache();
    void clearLOKSACache();
    void clearKEHRACache();
    void clearRAPINACache();
    void clearTOILACache();
    void clearKEILACache();
    void clearMUSTVEECache();
    void clearOTEPAACache();
}
