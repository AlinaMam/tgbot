package ru.skillfactorybot.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSkillfactoryTelegramBotApplication {

	public static void main(String[] args) {
		SpringApplication.from(SkillfactoryTelegramBotApplication::main).with(TestSkillfactoryTelegramBotApplication.class).run(args);
	}

}
