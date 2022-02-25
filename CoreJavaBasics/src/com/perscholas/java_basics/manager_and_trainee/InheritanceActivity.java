package com.perscholas.java_basics.manager_and_trainee;

public class InheritanceActivity {

    private static void testCaseOne() {
        Manager peter = new Manager(126534L, "Peter", "Chennai India", 237844L, 65000D);
        System.out.println(peter.calculateSalary());
        System.out.println(peter.calculateTransportAllowance());
    }

    private static void testCaseTwo() {
        Trainee jack = new Trainee(29846L, "Jack", "Mumbai India", 442085L, 45000D);
        System.out.println(jack.calculateSalary());
        System.out.println(jack.calculateTransportAllowance());
    }

    public static void main(String[] args) {
        testCaseOne();
        testCaseTwo();
    }
}
