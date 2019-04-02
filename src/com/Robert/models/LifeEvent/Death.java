package com.Robert.models.LifeEvent;

import com.Robert.models.Person.Person;
import java.util.Date;

import static com.Robert.configurations.LifeEventTypes.DEATH;
import static com.Robert.models.LifeEvent.MaritualStatus.MaritualStatusTypes.WIDOWED;

public class Death extends LifeEvent {

    private Person person;

    public Death(Person person, String place, Date date) {
        super(person, place, date);
        this.setType(DEATH);
        this.person.setAlive(false);
        if (this.person.getSpouse() != null) {
            this.person.getSpouse().setMaritualStatus(WIDOWED);
        }
    }
}
