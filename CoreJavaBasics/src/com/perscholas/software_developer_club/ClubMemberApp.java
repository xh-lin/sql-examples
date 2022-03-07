package com.perscholas.software_developer_club;

import java.io.File;
import java.io.FileNotFoundException;

public class ClubMemberApp {

    private static final String PATH = "/CoreJavaBasics/src/com/perscholas/software_developer_club";
    private static final String FILENAME = "members.txt";
    
    public static void main(String[] args) {
        String workingDirectory = System.getProperty("user.dir");

        File file = new File(workingDirectory + PATH, FILENAME);
        try {
            SoftwareDeveloperClub sdClub = new SoftwareDeveloperClub(file);
            for (ClubMember member : sdClub.getMembers()) {
                System.out.println();
                System.out.println(member);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
