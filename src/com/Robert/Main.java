package com.Robert;

import io.bretty.console.tree.TreePrinter;

import com.Robert.models.FamilyTree;
import com.Robert.models.LifeEvent.LifeEvent;
import com.Robert.models.LifeEvent.MaritualStatus;
import com.Robert.models.Person.Person;
import com.Robert.services.LifeEventService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static com.Robert.configurations.LifeEventTypes.*;

public class Main {

    public static void main(String[] args) throws Exception {

        FamilyTree familyTree = new FamilyTree();

        File family_Tree = new File("csaladfa.txt");
        String[] people = new String[4];
        try (BufferedReader br = new BufferedReader(new FileReader(family_Tree))){
            String str;
            while ((str = br.readLine()) != null) {
                people = str.split(",");
                String name = people[0];
                String birthPlace = people[1];
                String datum = people[2];
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
                Date date = dateFormat.parse(datum);
                String gender = people[3];
                Person person = new Person(name, birthPlace, date, gender); //
                familyTree.addToFamily(person);
                LifeEvent birth = new LifeEventService(person, birthPlace, date, BIRTH).createNewLifeEvent();
            }
        } catch (IOException e) {
            System.out.println("reading file failed " + e.getMessage());
        }

        familyTree.printFamilyTree();
        System.out.println(familyTree.toString());

        familyTree.findMemberOfFamily("Szomoru Antal")
                .addChild(familyTree.findMemberOfFamily("Szomoru Ilona"));
        familyTree.findMemberOfFamily("Szomoru Ilona")
                .addChild(familyTree.findMemberOfFamily("Mora Kornelia"));
        familyTree.findMemberOfFamily("Mora Kornelia")
                .addChild(familyTree.findMemberOfFamily("Popov Robert"));
        familyTree.findMemberOfFamily("Szomoru Ilona")
                .addChild(familyTree.findMemberOfFamily("Mora Robert"));
        familyTree.findMemberOfFamily("Mora Robert")
                .addChild(familyTree.findMemberOfFamily("Mora Istvan"));

        String output = TreePrinter.toString(familyTree.findMemberOfFamily("Szomoru Antal"));
        System.out.println(output);

        Date dateOfBirth = getDateEntry();
//        String placeOfBirth = getPlaceEntry();
//
        Person pisti = new Person("Móra István András", "Budapest", dateOfBirth, "M/m/MALE/Male/male");
        familyTree.addToFamily(pisti);
//        String place = "Bpest";
//        LifeEvent birth = new LifeEventService(pisti, pisti.getPlaceOfBirth(), pisti.getDateOfBirth(), BIRTH).createNewLifeEvent();
//        //MaritualStatus ms = new MaritualStatus(pisti);
//        //ms.addNewMarriageRelatedEvent();
//
        dateOfBirth = getDateEntry();
        String placeOfBirth = getPlaceEntry();
        Person marko = new Person("Móra Márko", "London", dateOfBirth, "M");
        familyTree.addToFamily(marko);
        familyTree.printFamilyTree();
        System.out.println(familyTree.findMemberOfFamily("Móra Márko").getDateOfBirth());

//        place = "Budapest";
        LifeEvent birth = new LifeEventService(marko, marko.getPlaceOfBirth(), dateOfBirth, BIRTH).createNewLifeEvent();
//
        pisti.addChild(marko);

        System.out.println("A keresztelő napja:");
        Date date = getDateEntry();
        LifeEvent baptist = new LifeEventService(marko, "Bpest", date, BAPTIST).createNewLifeEvent();

        System.out.println("A polgári esküvő napja:");
        Date date1 = getDateEntry();
        LifeEvent cWedding = new LifeEventService(marko, "Bpest", date, CIVIL_WEDDING).createNewLifeEvent();

        System.out.println("Az egyházi esküvő napja:");
        Date date2 = getDateEntry();
        LifeEvent eWedding = new LifeEventService(marko, "Bpest", date, ECCLESIASTIC_WEDDING).createNewLifeEvent();

        System.out.println("A válás napja:");
        Date date3 = getDateEntry();
        LifeEvent divorce = new LifeEventService(marko, "Bpest", date, DIVORCE).createNewLifeEvent();

        System.out.println(Arrays.toString(marko.getLifeEvents().toArray()));

//
//        familyTree.printFamilyTree();

         output = TreePrinter.toString(pisti);
        System.out.println(output);

    }

    public static Date getDateEntry () {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date (day.month.year.)");

        String date = scanner.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
        Date date2=null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //System.out.println(dateFormat.format(date2));
        return date2;
    }

    public static String getPlaceEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the place of event");

        return scanner.nextLine();
    }

}


