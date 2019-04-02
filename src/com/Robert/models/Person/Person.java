package com.Robert.models.Person;

import io.bretty.console.tree.PrintableTreeNode;

import com.Robert.models.LifeEvent.LifeEvent;
import com.Robert.models.LifeEvent.MaritualStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.Robert.models.LifeEvent.MaritualStatus.MaritualStatusTypes.SINGLE;

public class Person implements PrintableTreeNode {

    private String name;
    private String placeOfBirth;
    private Date dateOfBirth;
    private String gender;
    private boolean baptised = false;
    private Person spouse;
    private MaritualStatus.MaritualStatusTypes maritualStatus = SINGLE;
    private boolean alive = true;
    public Key key;

    private List<LifeEvent> lifeEvents;
    private List<Person> children;
    
    public Person(String name, String placeOfBirth, Date dateOfBirth, String gender) {
        this.name = name;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.lifeEvents = new ArrayList<>();
        this.key = new Key(name, dateOfBirth);
    }

    public Person(String name, Date dateOfBirth, String gender) {
        this(name, null, dateOfBirth, null);
    }

    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    
    

//    public void baptist(Person person) {
//        this.baptised = true;
//    }

    public void addChild(Person child) {

        this.children.add(child);
    }

    public void addEvent(LifeEvent event) {
        this.lifeEvents.add(event);
    }



    public String getName() {
        // return the name of the node that you wish to print later
        return this.name;
    }
    public String name() {return this.name;}

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getChildren() {
        // return the list of children of this node
        return this.children;
    }
    public List<Person> children() {
    	return this.children;
    } 

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public boolean isBaptised() {
        return baptised;
    }

    public void setBaptised(boolean baptised) {
        this.baptised = baptised;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public MaritualStatus.MaritualStatusTypes getMaritualStatus() {
        return maritualStatus;
    }

    public void setMaritualStatus(MaritualStatus.MaritualStatusTypes maritualStatus) {
        this.maritualStatus = maritualStatus;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public List<LifeEvent> getLifeEvents() {
        return lifeEvents;
    }

    public void setLifeEvents(List<LifeEvent> lifeEvents) {
        this.lifeEvents = lifeEvents;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public Key getKey() {
        return key;
    }

    public static final class Key implements Comparable{

        private String name;
        private Date dateOfBirth;

        public Key (String name, Date dateOfBirth) {
            this.name = name;
            this.dateOfBirth = dateOfBirth;
        }

        public String getName() {
            return name;
        }

        public Date getDateOfBirth() {
            return dateOfBirth;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 48 + this.dateOfBirth.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.dateOfBirth == key.getDateOfBirth());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + " born on " + this.dateOfBirth;
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

//	@Override
//	public List<? extends PrintableTreeNode> children() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String name() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
