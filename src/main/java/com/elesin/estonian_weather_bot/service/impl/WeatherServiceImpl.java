package com.elesin.estonian_weather_bot.service.impl;

import com.elesin.estonian_weather_bot.client.WeatherClient;
import com.elesin.estonian_weather_bot.exception.ServiceException;
import com.elesin.estonian_weather_bot.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    private static final String PALDISKI_XPATH = "/observations//station[3]/airtemperature";
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

    private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceImpl.class);

    //Overriding methods
    @Cacheable(value = "kuressaare", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherKuressaare() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KURESSAARE_XPATH);
    }

    @Cacheable(value = "tallinn", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherTallinn() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, TALLINN_XPATH);
    }

    @Cacheable(value = "kunda", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherKunda() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KUNDA_XPATH);
    }

    @Cacheable(value = "johvi", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherJohvi() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, JOHVI_XPATH);
    }

    @Cacheable(value = "narva", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherNarva() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, NARVA_XPATH);
    }

    @Cacheable(value = "vaikemarja", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherVaikeMaarja() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, VAIKEMARJA_XPATH);
    }

    @Cacheable(value = "jogeva", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherJogeva() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, JOGEVA_XPATH);
    }

    @Cacheable(value = "tartu", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherTartu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, TARTU_XPATH);
    }

    @Cacheable(value = "voru", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherVoru() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, VORU_XPATH);
    }

    @Cacheable(value = "valga", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherValga() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, VALGA_XPATH);
    }

    @Cacheable(value = "viljandi", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherViljandi() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, VILJANDI_XPATH);
    }

    @Cacheable(value = "kihnu", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherKihnu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KIHNU_XPATH);
    }

    @Cacheable(value = "haapsalu", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherHaapsalu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, HAAPSALU_XPATH);
    }

    @Cacheable(value = "paldiski", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherPaldiski() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, PALDISKI_XPATH);
    }

    @Cacheable(value = "parnu", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherParnu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, PARNU_XPATH);
    }

    @Cacheable(value = "narvajoesuu", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherNarvaJoesuu() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, NARVAJOESUU_XPATH);
    }

    @Cacheable(value = "pirita", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherPirita() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, PIRITA_XPATH);
    }

    @Cacheable(value = "loksa", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherLoksa() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, LOKSA_XPATH);
    }

    @Cacheable(value = "kehra", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherKehra() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KEHRA_XPATH);
    }

    @Cacheable(value = "rapina", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherRapina() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, RAPINA_XPATH);
    }

    @Cacheable(value = "toila", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherToila() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, TOILA_XPATH);
    }

    @Cacheable(value = "keila", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherKeila() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, KEILA_XPATH);
    }

    @Cacheable(value = "mustvee", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherMustvee() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, MUSTVEE_XPATH);
    }

    @Cacheable(value = "otepaa", unless = "#result == null or #result.isEmpty()")
    @Override
    public String getWeatherOtepaa() throws ServiceException {
        var xml = client.getWeatherXml();
        return extractWeatherDataFromXml(xml, OTEPAA_XPATH);
    }

    //Logging and Deleting Data from cach
    @CacheEvict("kuressaare")
    @Override
    public void clearKURESSAARECache() {
        LOG.info("Cache \"kuressaare\" cleared!");
    }

    @CacheEvict("tallinn")
    @Override
    public void clearTALLINNCache() {
        LOG.info("Cache \"tallinn\" cleared!");
    }

    @CacheEvict("kunda")
    @Override
    public void clearKUNDACache() {
        LOG.info("Cache \"kunda\" cleared!");
    }

    @CacheEvict("johvi")
    @Override
    public void clearJOHVICache() {
        LOG.info("Cache \"johvi\" cleared!");
    }

    @CacheEvict("narva")
    @Override
    public void clearNARVACache() {
        LOG.info("Cache \"narva\" cleared!");
    }

    @CacheEvict("vaikemarja")
    @Override
    public void clearVAIKEMARJACache() {
        LOG.info("Cache \"vaikemarja\" cleared!");
    }

    @CacheEvict("jogeva")
    @Override
    public void clearJOGEVACache() {
        LOG.info("Cache \"jogeva\" cleared!");
    }

    @CacheEvict("tartu")
    @Override
    public void clearTARTUCache() {
        LOG.info("Cache \"tartu\" cleared!");
    }

    @CacheEvict("voru")
    @Override
    public void clearVORUCache() {
        LOG.info("Cache \"voru\" cleared!");
    }

    @CacheEvict("valga")
    @Override
    public void clearVALGACache() {
        LOG.info("Cache \"valga\" cleared!");
    }

    @CacheEvict("viljandi")
    @Override
    public void clearVILJANDICache() {
        LOG.info("Cache \"viljandi\" cleared!");
    }

    @CacheEvict("kihnu")
    @Override
    public void clearKIHNUCache() {
        LOG.info("Cache \"kihnu\" cleared!");
    }

    @CacheEvict("haapsalu")
    @Override
    public void clearHAAPSALUCache() {
        LOG.info("Cache \"haapsalu\" cleared!");
    }

    @CacheEvict("paldiski")
    @Override
    public void clearPALDISKICache() {
        LOG.info("Cache \"paldiski\" cleared!");
    }

    @CacheEvict("parnu")
    @Override
    public void clearPARNUCache() {
        LOG.info("Cache \"parnu\" cleared!");
    }

    @CacheEvict("narvajoesuu")
    @Override
    public void clearNARVAJOESUUCache() {
        LOG.info("Cache \"narvajoesuu\" cleared!");
    }

    @CacheEvict("pirita")
    @Override
    public void clearPIRITACache() {
        LOG.info("Cache \"pirita\" cleared!");
    }

    @CacheEvict("loksa")
    @Override
    public void clearLOKSACache() {
        LOG.info("Cache \"loksa\" cleared!");
    }

    @CacheEvict("kehra")
    @Override
    public void clearKEHRACache() {
        LOG.info("Cache \"kehra\" cleared!");
    }

    @CacheEvict("rapina")
    @Override
    public void clearRAPINACache() {
        LOG.info("Cache \"rapina\" cleared!");
    }

    @CacheEvict("toila")
    @Override
    public void clearTOILACache() {
        LOG.info("Cache \"toila\" cleared!");
    }

    @CacheEvict("keila")
    @Override
    public void clearKEILACache() {
        LOG.info("Cache \"keila\" cleared!");
    }

    @CacheEvict("mustvee")
    @Override
    public void clearMUSTVEECache() {
        LOG.info("Cache \"mustvee\" cleared!");
    }

    @CacheEvict("otepaa")
    @Override
    public void clearOTEPAACache() {
        LOG.info("Cache \"otepaa\" cleared!");
    }


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
