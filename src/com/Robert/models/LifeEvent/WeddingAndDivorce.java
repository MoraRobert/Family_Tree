package com.Robert.models.LifeEvent;

import com.Robert.models.LifeEvent.LifeEvent;
import com.Robert.models.Person.Person;

import java.util.Date;

public abstract class WeddingAndDivorce extends LifeEvent {

    public WeddingAndDivorce(Person person, String place, Date date) {
        super(person, place, date);
    }


}
