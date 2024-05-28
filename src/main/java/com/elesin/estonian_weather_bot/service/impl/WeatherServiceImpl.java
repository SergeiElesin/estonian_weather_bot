package com.elesin.estonian_weather_bot.service.impl;

import com.elesin.estonian_weather_bot.client.WeatherClient;
import com.elesin.estonian_weather_bot.exception.ServiceException;
import com.elesin.estonian_weather_bot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;


@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String KURESSAARE_XPATH = "/observations//station[1]/airtemperature";
    private static final String TALLINN_XPATH = "/observations//station[2]/airtemperature";
    private static final String KUNDA_XPATH = "/observations//station[4]/airtemperature";
    private static final String JOHVI_XPATH = "/observations//station[5]/airtemperature";
    private static final String NARVA_XPATH = "/observations//station[6]/airtemperature";
    private static final String VAIKEMARJA_XPATH = "/observations//station[7]/airtemperature";
    private static final String JOGEVA_XPATH = "/observations//station[9]/airtemperature";
    private static final String TARTU_XPATH = "/observations//station[10]/airtemperature";
    private static final String VORU_XPATH = "/observations//station[11]/airtemperature";
    private static final String VALGA_XPATH = "/observations//station[12]/airtemperature";
    private static final String VILJANDI_XPATH = "/observations//station[13]/airtemperature";
    private static final String KIHNU_XPATH = "/observations//station[19]/airtemperature";
    private static final String HAAPSALU_XPATH = "/observations//station[24]/airtemperature";
    private static final String PALDISKI_XPATH = "/observations//station[29]/airtemperature";
    private static final String PARNU_XPATH = "/observations//station[30]/airtemperature";
    private static final String NARVAJOESUU_XPATH = "/observations//station[108]/airtemperature";
    private static final String PIRITA_XPATH = "/observations//station[39]/airtemperature";
    private static final String LOKSA_XPATH = "/observations//station[42]/airtemperature";
    private static final String KEHRA_XPATH = "/observations//station[51]/airtemperature";
    private static final String RAPINA_XPATH = "/observations//station[110]/airtemperature";
    private static final String TOILA_XPATH = "/observations//station[116]/airtemperature";
    private static final String KEILA_XPATH = "/observations//station[125]/airtemperature";
    private static final String MUSTVEE_XPATH = "/observations//station[149]/airtemperature";
    private static final String OTEPAA_XPATH = "/observations//station[154]/airtemperature";


    @Autowired
    private WeatherClient client;

    //Overriding methods
    public String getWeatherKuressaare() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KURESSAARE_XPATH);
    }

    @Override
    public String getWeatherTallinn() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, TALLINN_XPATH);
    }

    @Override
    public String getWeatherKunda() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KUNDA_XPATH);
    }

    @Override
    public String getWeatherJohvi() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, JOHVI_XPATH);
    }

    @Override
    public String getWeatherNarva() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, NARVA_XPATH);
    }

    @Override
    public String getWeatherVaikeMaarja() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, VAIKEMARJA_XPATH);
    }

    @Override
    public String getWeatherJogeva() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, JOGEVA_XPATH);
    }

    @Override
    public String getWeatherTartu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, TARTU_XPATH);
    }

    @Override
    public String getWeatherVoru() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, VORU_XPATH);
    }

    @Override
    public String getWeatherValga() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, VALGA_XPATH);
    }

    @Override
    public String getWeatherViljandi() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, VILJANDI_XPATH);
    }

    @Override
    public String getWeatherKihnu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KIHNU_XPATH);
    }

    @Override
    public String getWeatherHaapsalu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, HAAPSALU_XPATH);
    }

    @Override
    public String getWeatherPaldiski() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, PALDISKI_XPATH);
    }

    @Override
    public String getWeatherParnu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, PARNU_XPATH);
    }

    @Override
    public String getWeatherNarvaJoesuu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, NARVAJOESUU_XPATH);
    }

    @Override
    public String getWeatherPirita() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, PIRITA_XPATH);
    }

    @Override
    public String getWeatherLoksa() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, LOKSA_XPATH);
    }

    @Override
    public String getWeatherKehra() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KEHRA_XPATH);
    }

    @Override
    public String getWeatherRapina() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, RAPINA_XPATH);
    }

    @Override
    public String getWeatherToila() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, TOILA_XPATH);
    }

    @Override
    public String getWeatherKeila() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KEILA_XPATH);
    }

    @Override
    public String getWeatherMustvee() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, MUSTVEE_XPATH);
    }

    @Override
    public String getWeatherOtepaa() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, OTEPAA_XPATH);
    }

    //End overriding methods

    private static String extractWeatherDataFromXml(String xml, String xpathExpression) throws ServiceException {
        var source = new InputSource(new StringReader(xml));
        try{
            var xpath = XPathFactory.newInstance().newXPath();
            var document = (Document) xpath.evaluate("/", source, XPathConstants.NODE);

            return xpath.evaluate(xpathExpression, document);
        } catch (XPathExpressionException e) {
            throw new ServiceException("Xml Parsing Error", e);
        }

    }
}
