package ru.skillfactorybot.tgbot.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
//Ответ, который должен прийти по запросу GetCursOnDateXml
@XmlAccessorType(XmlAccessType.FIELD)//определяет сущности, которые используются в процессах преобразования
@XmlRootElement(name = "ValuteCursOnDate")//корневой элемент
@Data
public class ValuteCursOnDate {
    @XmlElement(name = "Vname")//название xml тега
    private String name;
    @XmlElement(name = "Vnom")
    private int nominal;
    @XmlElement(name = "Vcurs")
    private double course;
    @XmlElement(name = "Vcode")
    private String code;
    @XmlElement(name = "VchCode")
    private String chCode;
}
