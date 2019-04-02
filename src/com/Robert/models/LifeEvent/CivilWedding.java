package com.Robert.models.LifeEvent;

import com.Robert.configurations.LifeEventTypes;
import com.Robert.models.Person.Person;

import java.util.Date;

import static com.Robert.configurations.LifeEventTypes.CIVIL_WEDDING;
import static com.Robert.models.LifeEvent.MaritualStatus.MaritualStatusTypes.MARRIED;

public class CivilWedding extends WeddingAndDivorce {

    private Person person;

    public CivilWedding(Person person, String place, Date date, Person spouse) {
        super(person, place, date);
        this.setType(CIVIL_WEDDING);
        this.getPerson().setMaritualStatus(MARRIED);
        this.getPerson().setSpouse(spouse);
    }

}
