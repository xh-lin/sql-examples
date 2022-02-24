package com.perscholas.java_basics;

import java.util.ArrayList;
import java.util.List;

public class JavaBasicsLoops {

    static void a() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void b() {
        int i = 0;
        while (i <= 100) {
            System.out.print(i + " ");
            i += 10;
        }
        System.out.println();
    }

    static void c() {
        int i = 1;
        do {
            System.out.print(i++ + " ");
        } while (i <= 10);
        System.out.println();
    }

    static void d() {
        for (int i = 1; i <= 100; i++) {
            if (i >= 25 || i <= 75) {
                continue;
            }
            if (i % 5 == 0)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    static void e() {
        for (int i = 1; i <= 100; i++) {
            if (i > 50) {
                break;
            }
            if (i % 5 == 0)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    static void f() {
        for (int i = 1; i <= 2; i++) {
            System.out.println("Week " + i);
            for (int j = 1; j <= 5; j++) {
                System.out.println("Day " + j);
            }
        }
    }

    private static boolean isPalindrome(int num) {
        String s = String.valueOf(num);
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) 
                return false;
        }
        return true;
    }

    static void g() {
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i <= 200; i++) {
            if (isPalindrome(i)) {
                list.add(i);
            }
        }
        System.out.println(list);
    }

    static void h() {
        long a = 0;
        long b = 1;
        long n = 48;
        List<Long> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        while (n-- > 0) {
            long c = a + b;
            list.add(c);
            a = b;
            b = c;
        }
        System.out.println(list);
    }

    static void i() {
        int a = 3, b = 2;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.println("Inner loop: i: " + i + ", j: " + j);
            }
        }
    }

    public static void main(String[] args) {
        a();
        b();
        c();
        d();
        e();
        f();
        g();
        h();
        i();
    }
}
