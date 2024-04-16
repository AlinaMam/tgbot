package ru.skillfactorybot.tgbot.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

//ответ ValuteCursOnDate  десериализуется на три класса. Основной GetCursOnDateXmlResponse,
// в него вложен GetCursOnDateXmlResult, который уже содержит список ValuteCursOnDate
@XmlRootElement(name = "GetCursOnDateXMLResponse", namespace = "http://web.cbr.ru/")
//указываем xml тег и пространство имен
@XmlAccessorType(XmlAccessType.FIELD)//Аннотацией задаются поля которые будут серилизоваться и десериловаться.
@Data
public class GetCursOnDateXmlResponse {
    @XmlElement(name = "GetCursOnDateXMLResult", namespace = "http://web.cbr.ru/")//имя xml и его пространство имен
    private GetCursOnDateXmlResult getCursOnDateXmlResult;
}
