package com.Robert.models.LifeEvent;

import com.Robert.models.Person.Person;
import java.util.Date;
import static com.Robert.configurations.LifeEventTypes.DIVORCE;
import static com.Robert.models.LifeEvent.MaritualStatus.MaritualStatusTypes.DIVORCED;

public class Divorce extends WeddingAndDivorce {

    private Person spouse;

    public Divorce(Person person, String place, Date date, Person spouse) {
        super(person, place, date);
        this.setType(DIVORCE);
        this.getPerson().setMaritualStatus(DIVORCED);
        this.spouse = spouse;
        this.spouse.setMaritualStatus(DIVORCED);
    }
}
