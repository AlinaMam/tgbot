package ru.skillfactorybot.tgbot.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
//запрос
import javax.xml.datatype.XMLGregorianCalendar;
//Класс получения курса валют на конкретную дату
@Data
@XmlRootElement(name = "GetCursOnDateXML", namespace = "http://web.cbr.ru/")//элемент самого верхнего уровня
@XmlAccessorType(XmlAccessType.FIELD)
public class GetCursOnDateXml {
    //указание на то, в каком теге XML должно быть данное поле
    @XmlElement(name = "On_date", required = true, namespace = "http://web.cbr.ru/")
    protected XMLGregorianCalendar onDate;
}
