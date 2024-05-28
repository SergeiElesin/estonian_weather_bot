package com.elesin.estonian_weather_bot.scheduler;

import com.elesin.estonian_weather_bot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class InvalidationScheduler {

    @Autowired
    private WeatherService service;

    //Deleting cach every 24 hours
    //@Scheduled(cron = "* 0 0 * * ?")
    //Deleting cach every hour
    @Scheduled(cron = "0 0 * ? * *")
    public void invalidateCache() {

        service.clearKURESSAARECache();
        service.clearTALLINNCache();
        service.clearKUNDACache();
        service.clearJOHVICache();
        service.clearNARVACache();
        service.clearVAIKEMARJACache();
        service.clearJOGEVACache();
        service.clearTARTUCache();
        service.clearVORUCache();
        service.clearVALGACache();
        service.clearVILJANDICache();
        service.clearKIHNUCache();
        service.clearHAAPSALUCache();
        service.clearPALDISKICache();
        service.clearPARNUCache();
        service.clearNARVAJOESUUCache();
        service.clearPIRITACache();
        service.clearLOKSACache();
        service.clearKEHRACache();
        service.clearRAPINACache();
        service.clearTOILACache();
        service.clearKEILACache();
        service.clearMUSTVEECache();
        service.clearOTEPAACache();
    }
}

