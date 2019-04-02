package com.Robert.models.LifeEvent;

import com.Robert.configurations.LifeEventTypes;
import com.Robert.models.Person.Person;

import java.util.Date;

public abstract class LifeEvent {

    private Person person;
    private String place;
    private Date date;
    //private Key key;
    private LifeEventTypes type;
    //private Person godFathersName;
//    private Person godMothersName;
//    private Person spouse;

    public LifeEvent(Person person, String place, Date date) {
        this.person = person;
        this.place = place;
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setType(LifeEventTypes type) {
        this.type = type;
    }

    //    public static final class Key {
//
//
//    }



    public LifeEventTypes getType() {
        return type;
    }



    @Override
    public String toString() {
        return this.person.getName() + "'s " + this.getType();
    }
}
