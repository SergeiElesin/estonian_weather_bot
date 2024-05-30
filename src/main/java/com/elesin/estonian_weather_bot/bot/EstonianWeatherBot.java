package com.elesin.estonian_weather_bot.bot;

import com.elesin.estonian_weather_bot.exception.ServiceException;
import com.elesin.estonian_weather_bot.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;

@Component
public class EstonianWeatherBot extends TelegramLongPollingBot {

    private static final Logger LOG = LoggerFactory.getLogger(EstonianWeatherBot.class);

    private static final String START = "/start";
    private static final String TALLINN = "/tallinn";
    private static final String KURESSAARE = "/kuressaare";
    private static final String KUNDA = "/kunda";
    private static final String JOHVI = "/johvi";
    private static final String NARVA = "/narva";
    private static final String VAIKEMARJA = "/vaikemaarja";
    private static final String JOGEVA = "/jogeva";
    private static final String TARTU = "/tartu";
    private static final String VORU = "/voru";
    private static final String VALGA = "/valga";
    private static final String VILJANDI = "/viljandi";
    private static final String KIHNU = "/kihnu";
    private static final String HAAPSALU = "/haapsalu";
    private static final String PALDISKI = "/paldiski";
    private static final String PARNU = "/parnu";
    private static final String NARVAJOESUU = "/narvajoesuu";
    private static final String PIRITA = "/pirita";
    private static final String LOKSA = "/loksa";
    private static final String KEHRA = "/kehra";
    private static final String RAPINA = "/rapina";
    private static final String TOILA = "/toila";
    private static final String KEILA = "/keila";
    private static final String MUSTVEE = "/mustvee";
    private static final String OTEPAA = "/otepaa";

    private static final String HELP = "/help";

    @Autowired
    private WeatherService weatherService;

    public EstonianWeatherBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    //Commands
    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }
        var message = update.getMessage().getText();
        var chatId = update.getMessage().getChatId();
        switch (message){
            case START -> {
                String userName = update.getMessage().getChat().getUserName();
                startCommand(chatId, userName);
            }case HELP -> helpCommand(chatId);
            case TALLINN -> tallinnCommand(chatId);
            case KURESSAARE -> kuressaareCommand(chatId);
            case KUNDA -> kundaCommand(chatId);
            case JOHVI -> johviCommand(chatId);
            case NARVA -> narvaCommand(chatId);
            case VAIKEMARJA -> vaikeMarjaCommand(chatId);
            case JOGEVA -> jogevaCommand(chatId);
            case TARTU -> tartuCommand(chatId);
            case VORU -> voruCommand(chatId);
            case VALGA -> valgaCommand(chatId);
            case VILJANDI -> viljandiCommand(chatId);
            case KIHNU -> kihnuCommand(chatId);
            case HAAPSALU -> haapsaluCommand(chatId);
            case PALDISKI -> paldiskiCommand(chatId);
            case PARNU -> parnuCommand(chatId);
            case NARVAJOESUU -> narvaJoesuuCommand(chatId);
            case PIRITA ->piritaCommand(chatId);
            case LOKSA -> loksaCommand(chatId);
            case KEHRA -> kehraCommand(chatId);
            case RAPINA -> rapinaCommand(chatId);
            case TOILA -> toilaCommand(chatId);
            case KEILA -> keilaCommand(chatId);
            case MUSTVEE -> mustveeCommand(chatId);
            case OTEPAA -> otepaaCommand(chatId);

            default -> uncknownCommand(chatId);

        }
    }

    @Override
    public String getBotUsername() {
        return "${spring.application.name}";
    }

    //start
    private void startCommand(Long chatId, String userName){
        var text = """
                Welcome to Estonian Weather Bot, %s!
                
                Here you can find out the Air Temperature in Estonia.
                
                To select a location, use the commands:
                /tallinn
                /kuressaare
                /kunda
                /johvi
                /narva
                /vaikemaarja
                /jogeva
                /tartu
                /voru
                /valga
                /viljandi
                /kihnu
                /haapsalu
                /paldiski
                /parnu
                /narvajoesuu
                /pirita
                /loksa
                /kehra
                /rapina
                /toila
                /keila
                /mustvee
                /otepaa
                
                Additional commands:
                /help
                
                """;

        var formattedText = String.format(text, userName);
        sendMessage(chatId, formattedText);
    }


    //kuressaare
    private void kuressaareCommand(Long chatId) {
        String formattedText;
        try{
            var kuressaare = weatherService.getWeatherKuressaare();
            var text = "Air temperature in Kuressaare for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), kuressaare);
        } catch (ServiceException e){
            LOG.error("Getting Kuressaare failed", e);
            formattedText = "Getting Kuressaare failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //tallinn
    private void tallinnCommand(Long chatId) {
        String formattedText;
        try{
            var tallinn = weatherService.getWeatherTallinn();
            var text = "Air temperature in Tallin for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), tallinn);
        } catch (ServiceException e){
            LOG.error("Getting Tallinn failed", e);
            formattedText = "Getting Tallinn failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //kunda
    private void kundaCommand(Long chatId) {
        String formattedText;
        try{
            var kunda = weatherService.getWeatherKunda();
            var text = "Air temperature in Kunda for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), kunda);
        } catch (ServiceException e){
            LOG.error("Getting Kunda failed", e);
            formattedText = "Getting Kunda failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //Johvi
    private void johviCommand(Long chatId) {
        String formattedText;
        try{
            var johvi = weatherService.getWeatherJohvi();
            var text = "Air temperature in Jõhvi for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), johvi);
        } catch (ServiceException e){
            LOG.error("Getting Jõhvi failed", e);
            formattedText = "Getting Jõhvi failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //narva
    private void narvaCommand(Long chatId) {
        String formattedText;
        try{
            var narva = weatherService.getWeatherNarva();
            var text = "Air temperature in Narva for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), narva);
        } catch (ServiceException e){
            LOG.error("Getting Narva failed", e);
            formattedText = "Getting Narva failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    ///vaikemarja
    private void vaikeMarjaCommand(Long chatId) {
        String formattedText;
        try{
            var vaikeMarja = weatherService.getWeatherVaikeMaarja();
            var text = "Air temperature in Väike-Maarja for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), vaikeMarja);
        } catch (ServiceException e){
            LOG.error("Getting Väike-Maarja failed", e);
            formattedText = "Getting Väike-Maarja failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //jogeva
    private void jogevaCommand(Long chatId) {
        String formattedText;
        try{
            var jogeva = weatherService.getWeatherJogeva();
            var text = "Air temperature in Jõgeva for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), jogeva);
        } catch (ServiceException e){
            LOG.error("Getting Jõgeva failed", e);
            formattedText = "Getting Jõgeva failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //tartu
    private void tartuCommand(Long chatId) {
        String formattedText;
        try{
            var tartu = weatherService.getWeatherTartu();
            var text = "Air temperature in Tartu for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), tartu);
        } catch (ServiceException e){
            LOG.error("Getting Tartu failed", e);
            formattedText = "Getting Tartu failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //voru
    private void voruCommand(Long chatId) {
        String formattedText;
        try{
            var voru = weatherService.getWeatherVoru();
            var text = "Air temperature in Võru for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), voru);
        } catch (ServiceException e){
            LOG.error("Getting Võru failed", e);
            formattedText = "Getting Võru failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //valga
    private void valgaCommand(Long chatId) {
        String formattedText;
        try{
            var valga = weatherService.getWeatherValga();
            var text = "Air temperature in Valga for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), valga);
        } catch (ServiceException e){
            LOG.error("Getting Valga failed", e);
            formattedText = "Getting Valga failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //viljandi
    private void viljandiCommand(Long chatId) {
        String formattedText;
        try{
            var viljandi = weatherService.getWeatherViljandi();
            var text = "Air temperature in Viljandi for %s is %s degrees."  + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), viljandi);
        } catch (ServiceException e){
            LOG.error("Getting Viljandi failed", e);
            formattedText = "Getting Viljandi failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //kihnu
    private void kihnuCommand(Long chatId) {
        String formattedText;
        try{
            var kihnu = weatherService.getWeatherKihnu();
            var text = "Air temperature in Kihnu for %s is %s degrees."  + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), kihnu);
        } catch (ServiceException e){
            LOG.error("Getting Kihnu failed", e);
            formattedText = "Getting Kihnu failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //haapsalu
    private void haapsaluCommand(Long chatId) {
        String formattedText;
        try{
            var haapsalu = weatherService.getWeatherHaapsalu();
            var text = "Air temperature in Haapsalu for %s is %s degrees."  + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), haapsalu);
        } catch (ServiceException e){
            LOG.error("Getting Haapsalu failed", e);
            formattedText = "Getting Haapsalu failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //paldiski
    private void paldiskiCommand(Long chatId) {
        String formattedText;
        try{
            var paldiski = weatherService.getWeatherPaldiski();
            var text = "Air temperature in Paldiski for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), paldiski);
        } catch (ServiceException e){
            LOG.error("Getting Paldiski failed", e);
            formattedText = "Getting Paldiski failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //parnu
    private void parnuCommand(Long chatId) {
        String formattedText;
        try{
            var parnu = weatherService.getWeatherParnu();
            var text = "Air temperature in Pärnu for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), parnu);
        } catch (ServiceException e){
            LOG.error("Getting Pärnu failed", e);
            formattedText = "Getting Pärnu failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //narvaJoesuu
    private void narvaJoesuuCommand(Long chatId) {
        String formattedText;
        try{
            var narvaJoesuu = weatherService.getWeatherNarvaJoesuu();
            var text = "Air temperature in Narva-Jõesuu for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), narvaJoesuu);
        } catch (ServiceException e){
            LOG.error("Getting Narva-Jõesuu failed", e);
            formattedText = "Getting Narva-Jõesuu failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //pirita
    private void piritaCommand(Long chatId) {
        String formattedText;
        try{
            var pirita = weatherService.getWeatherPirita();
            var text = "Air temperature in Pirita for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), pirita);
        } catch (ServiceException e){
            LOG.error("Getting Pirita failed", e);
            formattedText = "Getting Pirita failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //loksa
    private void loksaCommand(Long chatId) {
        String formattedText;
        try{
            var loksa = weatherService.getWeatherLoksa();
            var text = "Air temperature in Loksa for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), loksa);
        } catch (ServiceException e){
            LOG.error("Getting Loksa failed", e);
            formattedText = "Getting Loksa failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //kehra
    private void kehraCommand(Long chatId) {
        String formattedText;
        try{
            var kehra = weatherService.getWeatherKehra();
            var text = "Air temperature in Kehra for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), kehra);
        } catch (ServiceException e){
            LOG.error("Getting Kehra failed", e);
            formattedText = "Getting Kehra failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //rapina
    private void rapinaCommand(Long chatId) {
        String formattedText;
        try{
            var rapina = weatherService.getWeatherRapina();
            var text = "Air temperature in Räpina for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), rapina);
        } catch (ServiceException e){
            LOG.error("Getting Räpina failed", e);
            formattedText = "Getting Räpina failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //toila
    private void toilaCommand(Long chatId) {
        String formattedText;
        try{
            var toila = weatherService.getWeatherToila();
            var text = "Air temperature in Toila for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), toila);
        } catch (ServiceException e){
            LOG.error("Getting Toila failed", e);
            formattedText = "Getting Toila failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //keila
    private void keilaCommand(Long chatId) {
        String formattedText;
        try{
            var keila = weatherService.getWeatherKeila();
            var text = "Air temperature in Keila for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), keila);
        } catch (ServiceException e){
            LOG.error("Getting Keila failed", e);
            formattedText = "Getting Keila failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //mustvee
    private void mustveeCommand(Long chatId) {
        String formattedText;
        try{
            var mustvee = weatherService.getWeatherMustvee();
            var text = "Air temperature in Mustvee for %s is %s degrees." + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), mustvee);
        } catch (ServiceException e){
            LOG.error("Getting Mustvee failed", e);
            formattedText = "Getting Mustvee failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //otepaa
    private void otepaaCommand(Long chatId) {
        String formattedText;
        try{
            var otepaa = weatherService.getWeatherOtepaa();
            var text = "Air temperature in Otepää for %s is %s degrees."  + "\n" + "Have a nice day!";
            formattedText = String.format(text, LocalDate.now(), otepaa);
        } catch (ServiceException e){
            LOG.error("Getting Otepää failed", e);
            formattedText = "Getting Otepää failed, try later";
        }
        sendMessage(chatId, formattedText);
    }

    //help
    private void helpCommand(Long chatId) {
        var text = """
                /tallinn - air temperature in Tallinn
                /kuressaare - air temperature in Kuressaare
                /kunda - air temperature in Kunda
                /johvi - air temperature in Jõhvi
                /narva - air temperature in Narva
                /vaikemaarja - air temperature in Väike-Maarja
                /jogeva - air temperature in Jõgeva
                /tartu - air temperature in Tartu
                /voru - air temperature in Võru
                /valga - air temperature in Valga
                /viljandi - air temperature in Viljandi
                /kihnu - air temperature in Kihnu
                /haapsalu - air temperature in Haapsalu
                /paldiski - air temperature in Paldiski
                /parnu - air temperature in Pärnu
                /narvajoesuu - air temperature in Narva-Jõesuu
                /pirita - air temperature in Pirita
                /loksa - air temperature in Loksa
                /kehra - air temperature in Kehra
                /rapina - air temperature in Räpina
                /toila - air temperature in Toila
                /keila - air temperature in Keila
                /mustvee - air temperature in Mustvee
                /otepaa - air temperature in Otepää
                
                Sourse: Estonian Environment Agency, ilmateenistus.ee
                
                """;
        sendMessage(chatId, text);
    }

    //Unknown command
    private void uncknownCommand(Long chatId) {
        var text = "Could not recognize the command";
        sendMessage(chatId, text);
    }

    //Send message
    private void sendMessage(Long chatId, String text) {
        var chatIdStr = String.valueOf(chatId);
        var sendMessage = new SendMessage(chatIdStr, text);
        try {
            execute(sendMessage);
        }catch (TelegramApiException e) {
            LOG.error("Message error", e);
        }
    }
}
