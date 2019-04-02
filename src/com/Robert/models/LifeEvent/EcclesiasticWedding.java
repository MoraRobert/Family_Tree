package com.Robert.models.LifeEvent;

import com.Robert.configurations.LifeEventTypes;
import com.Robert.models.Person.Person;

import java.util.Date;

import static com.Robert.configurations.LifeEventTypes.ECCLESIASTIC_WEDDING;

public class EcclesiasticWedding extends WeddingAndDivorce {

    public EcclesiasticWedding(Person person, String place, Date date, Person spouse, Confessions  confession) {
        super(person, place, date);
        this.setType(ECCLESIASTIC_WEDDING);
    }

    public enum Confessions {

        CHRISTIAN,
        MUSLIM,
        UNAFFILIATED,
        HINDU,
        BUDHIST,
        FOLK_RELIGION,
        OTHER,

    }
}



