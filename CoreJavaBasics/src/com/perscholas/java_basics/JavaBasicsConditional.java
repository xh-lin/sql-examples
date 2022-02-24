package com.perscholas.java_basics;

import java.util.Scanner;

public class JavaBasicsConditional {
    
    static void a() {
        var x = 7;
        if (x < 10) System.out.println("Less than 10");
        x = 15;
        if (x < 10) System.out.println("Less than 10");
    }

    static void b() {
        var x = 7;
        if (x < 10) System.out.println("Less than 10");
        else System.out.println("Greater than 10");
        x = 15;
        if (x < 10) System.out.println("Less than 10");
        else System.out.println("Greater than 10");
    }

    static void c() {
        var x = 7;
        if (x < 10) System.out.println("Less than 10");
        else if (x < 20) System.out.println("Between 10 and 20");
        else System.out.println("Greater than or equal to 20");
        x = 15;
        if (x < 10) System.out.println("Less than 10");
        else if (x < 20) System.out.println("Between 10 and 20");
        else System.out.println("Greater than or equal to 20");
    }

    static void d() {
        var x = 15;
        if (x < 10 || x > 20) System.out.println("Out of range");
        else System.out.println("In range");
        x = 5;
        if (x < 10 || x > 20) System.out.println("Out of range");
        else System.out.println("In range");
    }

    static void e() {
        Scanner scanner = new Scanner(System.in);
        int grade = scanner.nextInt();
        if (grade > 100 || grade < 0) System.out.println("Score out of range.");
        else if (grade >= 90) System.out.println("A");
        else if (grade >= 80) System.out.println("B");
        else if (grade >= 70) System.out.println("C");        
        else if (grade >= 60) System.out.println("D");
        else System.out.println("F");
    }

    static void f() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Out of range");
        }
    }
    
    public static void main(String[] args) {
        a();
        b();
        c();
        d();
        e();
        f();
    }
}
