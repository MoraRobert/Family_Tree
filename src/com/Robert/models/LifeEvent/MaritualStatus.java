package com.Robert.models.LifeEvent;

import com.Robert.models.LifeEvent.LifeEvent;
import com.Robert.models.Person.Person;

import java.util.ArrayList;
import java.util.List;

public class MaritualStatus {

    private MaritualStatusTypes maritualStatus;
    private LifeEvent lastCivilWedding = null;  //TODO: meg a másik
    private List<LifeEvent> listOfEcclesiasticWeddings;
    private List<LifeEvent> marriageRelatedEvents;
    private LifeEvent lastDevorce;

    public MaritualStatus(Person person) {

        this.marriageRelatedEvents = new ArrayList<>();
    }

    public void addNewMarriageRelatedEvent(LifeEvent marriageRelatedEvent) {
        marriageRelatedEvents.add(marriageRelatedEvent);
    }

//    public void checkMaritualStatus(List marriageRelatedEvents) {
//
//        for (int i = marriageRelatedEvents.size() - 1; i > 0; i--) {
//            if (marriageRelatedEvents.get(i).)
//        }
//    }

    public enum MaritualStatusTypes {
        SINGLE,
        MARRIED,
        DIVORCED,
        WIDOWED,
    }

}


