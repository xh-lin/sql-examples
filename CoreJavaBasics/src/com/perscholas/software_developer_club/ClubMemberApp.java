package com.perscholas.software_developer_club;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClubMemberApp {

    private static final String PATH = "/CoreJavaBasics/src/com/perscholas/software_developer_club";
    private static final String FILENAME = "members.txt";
    private static final String PLZ_ENTER_NUM = "Please enter a number:";
    private static final String PLZ_SELECT_NUM_ONE_TO_FOUR = "Please enter a number between 1 and 4:";
    private static final String ENTER_NAME = "Please enter name:";
    private static final String ENTER_CITY = "Please enter city:";
    private static final String ENTER_SATE = "Please enter state:";
    private static final String ENTER_FAV_LANG = "Please enter favorite language:";
    private static final String MEMBER_ADDED = "\nA new member has been added.";
    private static final String MEMVER_REMOVED = "\nThe member has been removed.";
    private static final String SELECT_INDEX = "\nPlease select an index between 0 and %d:\n";

    private static SoftwareDeveloperClub sdClub;

    private static void printMenu() {
        System.out.printf("%nSelect from the following menu:%n1. Display Members%n2. Remove Member%n3. Add Member%n4. Quit%n");
        printWaitInput();
    }

    private static void printWaitInput() {
        System.out.print("> ");
    }

    private static void menuHandler(int option, Scanner sc) {
        switch (option) {
            case 1: // display members
                sdClub.printMembers(false);
                break;
            case 2: // remove member
                sdClub.printMembers(true);
                System.out.printf(SELECT_INDEX, sdClub.size() - 1);
                printWaitInput();
                while (sc.hasNext()) {
                    if (sc.hasNextInt()) {
                        int index = sc.nextInt();
                        if (index >= 0 && index < sdClub.size()) {
                            System.out.println();
                            System.out.println(sdClub.removeMember(index));
                            System.out.println(MEMVER_REMOVED);
                            break;
                        } else {
                            System.out.printf(SELECT_INDEX, sdClub.size() - 1);
                        }
                    } else {
                        System.out.println(PLZ_ENTER_NUM);
                    }
                }
                break;
            case 3: // add member
                System.out.println(ENTER_NAME);
                printWaitInput();
                String name = sc.nextLine().trim();
                System.out.println(ENTER_CITY);
                printWaitInput();
                String city = sc.nextLine().trim();
                System.out.println(ENTER_SATE);
                printWaitInput();
                String state = sc.nextLine().trim();
                System.out.println(ENTER_FAV_LANG);
                printWaitInput();
                String favLang = sc.nextLine().trim();
                
                ClubMember member = new ClubMember(name, city + ", " + state, favLang);
                sdClub.addMember(member);
                System.out.println();
                System.out.println(member);
                System.out.println(MEMBER_ADDED);
                break;
            default:
                System.out.println(PLZ_SELECT_NUM_ONE_TO_FOUR);
        }
    }
    
    public static void main(String[] args) {
        String workingDirectory = System.getProperty("user.dir");
        File file = new File(workingDirectory + PATH, FILENAME);

        try {
            sdClub = new SoftwareDeveloperClub(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Scanner sc = new Scanner(System.in);
        printMenu();

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int option = sc.nextInt();
                sc.nextLine(); // skip carriage return for next input
                if (option == 4) {
                    break;
                } else {
                    menuHandler(option, sc);
                }
            } else {
                System.out.println(PLZ_ENTER_NUM);
            }

            printMenu();
        }

        sc.close();
    }

}
