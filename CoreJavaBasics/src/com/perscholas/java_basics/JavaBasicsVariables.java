package com.perscholas.java_basics;

public class JavaBasicsVariables {

    private static void A() {
        int n1 = 1, n2 = 2;
        var sum = n1 + n2;
        System.out.println(sum);
    }

    private static void B() {
        double d1 = 1.1d, d2 = 2.2d;
        var sum = d1 + d2;
        System.out.println(sum);
    }

    /*
        What variable type must the sum be?

        Addtion b/w int and double gives you double, but int or some other types is also fine if you want to convert it to another type.
    */
    private static void C() {
        int n4 = 4;
        double d4 = 4.4d;
        var d5 = n4 + d4;
        System.out.println(d5);
    }

    /*
        What happens? What corrections are needed?

        integer division gives you an integer, thus no decimal. If you don't want to lose info, convert either divisor or dividend into decimal before division.
    */
    private static void D() {
        int n1 = 2, n2 = 5;
        var n3 = n2 / n1;
        System.out.println(n3);
        var n4 = (double) n2 / n1;
        System.out.println(n4);
    }

    private static void E() {
        double d1 = 1.23d, d2 = 4.56d;
        double d3 = d2 / d1;
        System.out.println(d3);
        System.out.println((int) d3);
    }

    private static void F() {
        int x = 5, y = 6;
        double q = y / x;
        System.out.println(q);
        q = (double) y / x;
        System.out.println(q);
    }

    private static final double PI = 3.14d;

    private static void G(double r) {
        System.out.println(2 * PI * r);
    }

    private static final double SALES_TAX = 1.23d;

    private static void H() {
        double coffee = 2.75d;
        double cappuccino = 4.75d;
        double greenTea = 2.25d;

        double subtotal = 3*coffee + 4*cappuccino + 2*greenTea;
        double totalSale = subtotal + SALES_TAX;
        System.out.printf("%.2f\n", totalSale);
    }

    public static void main(String[] args) {
        A();
        B();
        C();
        D();
        E();
        F();
        G(3);
        H();
    }

}
