package com.Robert.models;

import com.Robert.models.Person.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FamilyTree {

    //Map<Person.Key, Person> familyTree = new TreeMap<>(); //TODO: check if compareTo() is OK
    Map<String, Person> familyTree = new TreeMap<>();

    public void addToFamily(Person person) {
        familyTree.put(person.getName(), person);
        //familyTree.put(person.getKey(), person);
    }

    public Person findMemberOfFamily(String name) {
        if (familyTree.containsKey(name)) {
            return familyTree.get(name);
        } else {
            System.out.println(name + " is not a member of the familytree");
            return null;
        }

    }

    public Map<String, Person> getFamilyTree() {
        return familyTree;
    }

    public void printFamilyTree() {
        familyTree.keySet().stream().forEach(System.out :: println);
    }


}
