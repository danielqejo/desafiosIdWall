package idwall.desafio.redditcrawler;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import idwall.desafio.redditcrawler.telegram.bots.DanielIdWallBot;

public class TelegramBotApplication {
	
	public static void main(String[] args) {
		ApiContextInitializer.init();
		
		TelegramBotsApi botsApi = new TelegramBotsApi();
		
		try {
            botsApi.registerBot(new DanielIdWallBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}
}
