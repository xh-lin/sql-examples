package jpa.mainrunner;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

    private static final String LOGIN_MENU = "Are you a(n)%n 1. Student%n 2. quit%n";
    private static final String ENTER_ONLY_ONE_OR_TWO = "Please, enter 1 or 2.%n";
    private static final String EMAIL_PROMPT = "Enter Your Email:%n";
    private static final String PASSWORD_PROMPT = "Enter Your Password:%n";
    private static final String MY_CLASSES = "My Classes:%n";
    private static final String ALL_COURSES = "All Courses:%n";
    private static final String COURSE_HEADER = "%-4s%-30s%s%n";
    private static final String ID = "ID";
    private static final String COURSE_NAME = "COURSE NAME";
    private static final String INSTRUCTOR_NAME = "INSTRUCTOR NAME";
    private static final String COURSE_FORMAT = "%-4d%-30s%s%n";
    private static final String COURSE_MENU = " 1. Register to Class%n 2. Logout%n";
    private static final String COURSE_PROMPT = "Which Course?%n";
    private static final String SIGNED_OUT_MESSAGE = "You have been signed out.%n";
    private static final String WRONG_CREDENTIALS = "Wrong Credentials%n";
    private static final String ENTER_A_VALID_COURSE_ID = "Please enter a valid course ID:%n";
    private static final String ALREADY_REGISTERED = "You are already registered in that course!";

    private static CourseService courseService = new CourseService();
    private static StudentService studentService = new StudentService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean exitStatus = loginMenuHandler(sc);
        printf("%n%n");
        printf(
            exitStatus
            ? SIGNED_OUT_MESSAGE
            : WRONG_CREDENTIALS);

        sc.close();
    }

    private static boolean loginMenuHandler(Scanner sc) {
        printf(LOGIN_MENU);
        printf("%n");
        printf(ENTER_ONLY_ONE_OR_TWO);

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int option = sc.nextInt();
                sc.nextLine(); // ignore new line character
                if (option == 1) {
                    printf(EMAIL_PROMPT);
                    String email = sc.nextLine().trim();
                    printf(PASSWORD_PROMPT);
                    String password = sc.nextLine().trim();
                    printf("%n%n");

                    if (studentService.validateStudent(email, password)) {
                        // course menu
                        courseMenuHandler(sc, email);
                        return true;
                    } else {
                        return false;
                    }
                } else if (option == 2) {
                    return true;
                } else {
                    printf(ENTER_ONLY_ONE_OR_TWO);
                }
            } else {
                // in case of user enterd multiple new lines before entering a vlaue
                // skip empty lines, so only show prompt once
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    printf(ENTER_ONLY_ONE_OR_TWO);
                }
            }
        }

        return false;
    }

    private static void courseMenuHandler(Scanner sc, String email) {
        showStudentClasses(email);

        printf("%n");
        printf(COURSE_MENU);

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int option = sc.nextInt();
                sc.nextLine(); // ignore new line character
                if (option == 1) {
                    printf("%n%n");
                    courseRegistrationHandler(sc, email);
                    return;
                } else if (option == 2) {
                    return;
                } else {
                    printf(ENTER_ONLY_ONE_OR_TWO);
                }
            } else {
                // in case of user enterd multiple new lines before entering a vlaue
                // skip empty lines, so only show prompt once
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    printf(ENTER_ONLY_ONE_OR_TWO);
                }
            }
        }
    }

    private static void courseRegistrationHandler(Scanner sc, String email) {
        List<Course> sCourses = studentService.getStudentByEmail(email).getSCourses();
        List<Course> allCourses = courseService.getAllCourses();
        Set<Integer> sIds = new HashSet<>();
        Set<Integer> allIds = new HashSet<>();
        for (Course c : sCourses) {
            sIds.add(c.getCId());
        }
        for (Course c : allCourses) {
            allIds.add(c.getCId());
        }

        printf("%n%n");
        printf(ALL_COURSES);
        printf(COURSE_HEADER, ID, COURSE_NAME, INSTRUCTOR_NAME);

        for (Course course : allCourses) {
            printf(COURSE_FORMAT, course.getCId(), course.getCName(), course.getCInstructorName());
        }

        printf("%n");
        printf(COURSE_PROMPT);

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int option = sc.nextInt();
                sc.nextLine(); // ignore new line character
                if (allIds.contains(option)) {
                    if (sIds.contains(option)) {
                        printf(ALREADY_REGISTERED);
                    } else {
                        printf("%n%n");
                        studentService.registerStudentToCourse(email, option);
                    }
                    break;
                } else {
                    printf(ENTER_A_VALID_COURSE_ID);
                }
            } else {
                // in case of user enterd multiple new lines before entering a vlaue
                // skip empty lines, so only show prompt once
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    printf(ENTER_A_VALID_COURSE_ID);
                }
            }
        }

        showStudentClasses(email);
    }

    private static void showStudentClasses(String email) {
        Student student = studentService.getStudentByEmail(email);

        printf("%n%n");
        printf(MY_CLASSES);
        printf(COURSE_HEADER, ID, COURSE_NAME, INSTRUCTOR_NAME);

        for (Course course : student.getSCourses()) {
            printf(COURSE_FORMAT, course.getCId(), course.getCName(), course.getCInstructorName());
        }
    }

    private static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

}
