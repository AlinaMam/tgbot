package ru.skillfactorybot.tgbot.config;

import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPConstants;
import jakarta.xml.soap.SOAPException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.Jaxb2CollectionHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import ru.skillfactorybot.tgbot.dto.GetCursOnDateXml;
import ru.skillfactorybot.tgbot.dto.GetCursOnDateXmlResponse;
import ru.skillfactorybot.tgbot.dto.GetCursOnDateXmlResult;
import ru.skillfactorybot.tgbot.dto.ValuteCursOnDate;
import ru.skillfactorybot.tgbot.service.CentralRussianBankService;

import java.nio.charset.StandardCharsets;

//Здесь хранятся бины конфигурации
@Configuration
public class AppConfig {
    @Bean
    public CentralRussianBankService cbrService() throws SOAPException {
        CentralRussianBankService cbrService = new CentralRussianBankService();
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();//для маршаллинга и анмаршаллинга SOAP-объектов
        MessageFactory msgFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);//Фабрика для того, чтобы создать SOAPMessage объекты
        SaajSoapMessageFactory newSoapMessageFacory = new SaajSoapMessageFactory(msgFactory);
        cbrService.setMessageFactory(newSoapMessageFacory);

        jaxb2Marshaller.setClassesToBeBound(
                GetCursOnDateXml.class,
                GetCursOnDateXmlResponse.class,
                GetCursOnDateXmlResult.class,
                ValuteCursOnDate.class
        );
        cbrService.setMarshaller(jaxb2Marshaller);
        cbrService.setUnmarshaller(jaxb2Marshaller);
        return cbrService;
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding(StandardCharsets.UTF_8.name());
        filter.setForceEncoding(true);
        return filter;
    }

}
