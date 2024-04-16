package ru.skillfactorybot.tgbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.WebServiceTemplate;
import ru.skillfactorybot.tgbot.dto.GetCursOnDateXml;
import ru.skillfactorybot.tgbot.dto.GetCursOnDateXmlResponse;
import ru.skillfactorybot.tgbot.dto.ValuteCursOnDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

//WebServiceTemplate - удобный способ взаимодействия с SOAP веб-сервисами
//класс будет отправлять запросы в сторону API Центрального банка
public class CentralRussianBankService extends WebServiceTemplate {
    @Value("${cbr.api.url}")
    private String cbrApiUrl;//сюда поставляется значение из application.properties

    //метод получения данных
    public List<ValuteCursOnDate> getCurrenciesFromCbr() throws DatatypeConfigurationException {
        final GetCursOnDateXml getCursOnDateXml = new GetCursOnDateXml();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
//дата в xml
        XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        //получение объекта GetCursOnDateXmlResponse
        //ответ десериализуется на три класса. Основной GetCursOnDateXmlResponse,
        //в него вложен GetCursOnDateXmlResult, который уже содержит список ValuteCursOnDate
        GetCursOnDateXmlResponse response = (GetCursOnDateXmlResponse) marshalSendAndReceive(cbrApiUrl, getCursOnDateXml);
        if (response == null) {
            throw new IllegalStateException("Could not get response from CBR Service");
        }
        final List<ValuteCursOnDate> courses = response.getGetCursOnDateXmlResult().getValuteDate();
        courses.forEach(course -> course.setName(course.getName().trim()));
        return courses;
    }

}
