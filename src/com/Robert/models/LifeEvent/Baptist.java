package com.Robert.models.LifeEvent;

import java.util.Date;

import com.Robert.models.Person.Person;
import static com.Robert.configurations.LifeEventTypes.BAPTIST;

public class Baptist extends LifeEvent {

    private Person godFather;
    private Person godMother;

    public Baptist(Person person, String place, Date date, Person godFather, Person godMother) {
        super(person, place, date);
        this.godFather = godFather;
        this.godMother = godMother;
        this.getPerson().setBaptised(true);
        this.setType(BAPTIST);
    }


}
