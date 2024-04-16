package ru.skillfactorybot.tgbot.dto;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//Получение списка курсов валют
@XmlAccessorType(XmlAccessType.FIELD)// доступ будет напрямую к полю и не требуется создавать геттеры и сеттеры.
@XmlRootElement(name = "GetCursOnDateXmlResult")
@Data
public class GetCursOnDateXmlResult {
    @XmlElementWrapper(name = "ValuteData", namespace = "")//создает обертку вокруг группы повторяющихся тегов
    @XmlElement(name = "ValuteCursOnDate", namespace = "")
    private List<ValuteCursOnDate> valuteDate = new ArrayList<>();
}
