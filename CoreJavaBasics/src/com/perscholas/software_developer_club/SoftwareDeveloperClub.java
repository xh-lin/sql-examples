package com.perscholas.software_developer_club;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoftwareDeveloperClub {

    private static final String DELIMITER = "(\\*\\*)|(\n)";

    List<ClubMember> members = new ArrayList<>();

    SoftwareDeveloperClub() { }

    SoftwareDeveloperClub(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        sc.useDelimiter(DELIMITER);
        sc.next();
        sc.next();
        sc.next();
        sc.next();
        while (sc.hasNext()) {
            String name = sc.next();
            String city = sc.next();
            String state = sc.next();
            String favoriteLanguage = sc.next();
            members.add(new ClubMember(name, city + ", " + state, favoriteLanguage));
        }
        sc.close();
    }

    public List<ClubMember> getMembers() {
        return this.members;
    }

    public int size() {
        return this.members.size();
    }

    public void printMembers(boolean withIndex) {
        for (int i = 0; i < this.members.size(); i++) {
            System.out.println("\n" + (withIndex ? i+".\n" : "") + members.get(i));
        }
    }

    public ClubMember removeMember(int index) {
        return members.remove(index);
    }

    public void addMember(ClubMember member) {
        members.add(member);
    }

    public void addMember(String name, String city, String favoriteLanguage) {
        members.add(new ClubMember(name, city, favoriteLanguage));
    }

}
