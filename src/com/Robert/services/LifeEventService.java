package com.Robert.services;

import com.Robert.configurations.LifeEventTypes;
import com.Robert.models.LifeEvent.*;
import com.Robert.models.Person.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static com.Robert.models.LifeEvent.EcclesiasticWedding.Confessions.CHRISTIAN;
import static com.Robert.models.LifeEvent.MaritualStatus.MaritualStatusTypes.MARRIED;
import static com.Robert.models.LifeEvent.MaritualStatus.MaritualStatusTypes.WIDOWED;

public class LifeEventService {

    private Person person;
    private String placeOfEvent;
    private Date dateOfEvent;
    private LifeEventTypes lifeEventType;

    public LifeEventService(Person person, String placeOfEvent, Date dateOfEvent, LifeEventTypes lifeEventType) {
        this.person = person;
        this.placeOfEvent = placeOfEvent;
        this.dateOfEvent = dateOfEvent;
        this.lifeEventType = lifeEventType;
    }

    public LifeEvent createNewLifeEvent() {
        Scanner scanner = new Scanner(System.in);
        LifeEvent lifeEvent = null;
        switch (this.lifeEventType){
            case BIRTH:
                lifeEvent = new Birth(this.person);
                lifeEvent.setType(LifeEventTypes.BIRTH);
                this.person.addEvent(lifeEvent);
                break;
            case BAPTIST:
                System.out.println("Please enter the name of the godfather");
                String name = scanner.nextLine();
                System.out.println("Please enter the date of birth of the godfather");
                Date date = getDateEntry(scanner);
                scanner.nextLine();
                Person godFather = new Person(name, date, "M");
                System.out.println("Please enter the name of the godmother");
                name = scanner.nextLine();
                System.out.println("Please enter the date of birth of the godmother");
                date = getDateEntry(scanner);
                Person godMother = new Person(name, date, "F");
                lifeEvent = new Baptist(this.person, this.placeOfEvent, this.dateOfEvent, godFather, godMother);
                this.person.addEvent(lifeEvent);
                break;
            case CIVIL_WEDDING:
                System.out.println("Please enter the name of the spouse");
                name = scanner.nextLine();
                System.out.println("Please enter the date of birth of the spouse");
                date = getDateEntry(scanner);
                System.out.println("Please enter the gender of the spouse (M or F)");
                String gender = scanner.nextLine();
                scanner.nextLine();
                Person spouse = new Person(name, date, gender);
                lifeEvent = new CivilWedding(this.person, this.placeOfEvent, this.dateOfEvent, spouse);
                this.person.addEvent(lifeEvent);
                //this.person.setMaritualStatus(MARRIED); //konstruktorban
                lifeEvent = new CivilWedding(spouse, this.placeOfEvent, this.dateOfEvent, this.person);
                spouse.addEvent(lifeEvent);
                break;
            case ECCLESIASTIC_WEDDING:
                System.out.println("Please enter the name of the spouse");
                name = scanner.nextLine();
                System.out.println("Please enter the date of birth of the spouse");
                date = getDateEntry(scanner);
                if (this.person.getGender().equals("M") || this.person.getGender().equals("MALE")) {
                    gender = "F";
                } else {gender = "M";}
                spouse = new Person(name, date, gender);
//                System.out.println("Please enter the confession of the wedding");
//                String confession = scanner.nextLine();
//                EcclesiasticWedding.Confessions conf = EcclesiasticWedding.Confessions.valueOf(confession);
                lifeEvent = new EcclesiasticWedding(this.person, this.placeOfEvent, this.dateOfEvent, spouse, CHRISTIAN);
                this.person.addEvent(lifeEvent);
                lifeEvent = new EcclesiasticWedding(spouse, this.placeOfEvent, this.dateOfEvent, person, CHRISTIAN);
                spouse.addEvent(lifeEvent);
                break;
            case DIVORCE:
                spouse = this.person.getSpouse();
                lifeEvent = new Divorce(this.person, this.placeOfEvent, this.dateOfEvent, spouse);
                this.person.addEvent(lifeEvent);
                lifeEvent = new Divorce(spouse, this.placeOfEvent, this.dateOfEvent, this.person);
                spouse.addEvent(lifeEvent);
                break;
            case DEATH:
                lifeEvent = new Death(this.person, this.placeOfEvent, this.dateOfEvent);
                this.person.addEvent(lifeEvent);
                if (this.person.getMaritualStatus() == MARRIED) { // .equals() szintén jó !?
                    this.person.getSpouse().setMaritualStatus(WIDOWED);
                }
                break;
        }
        return lifeEvent;
    }

    public Date getDateEntry (Scanner scanner) {

        String date = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
        Date date2 = null;
        try {
            date2 = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date2;
    }

}
