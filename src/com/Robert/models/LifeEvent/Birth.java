package com.Robert.models.LifeEvent;

import com.Robert.models.Person.Person;

import static com.Robert.configurations.LifeEventTypes.BIRTH;

public class Birth extends LifeEvent {

    public Birth(Person person)
    {
        super(person, person.getPlaceOfBirth(), person.getDateOfBirth());
        this.setType(BIRTH);
    }

}
