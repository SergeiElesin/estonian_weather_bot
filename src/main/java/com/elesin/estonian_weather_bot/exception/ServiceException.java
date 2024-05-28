package com.elesin.estonian_weather_bot.exception;

public class ServiceException extends Exception{
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
