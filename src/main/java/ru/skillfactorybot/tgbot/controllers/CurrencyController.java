package ru.skillfactorybot.tgbot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactorybot.tgbot.dto.ValuteCursOnDate;
import ru.skillfactorybot.tgbot.service.CentralRussianBankService;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {
    private final CentralRussianBankService centralRussianBankService;

    @GetMapping("/getCurrencies")
    public List<ValuteCursOnDate> getValuteCursOndate() throws DatatypeConfigurationException {
        return centralRussianBankService.getCurrenciesFromCbr();
    }
}
