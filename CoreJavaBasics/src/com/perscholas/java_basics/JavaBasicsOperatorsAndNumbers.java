package com.perscholas.java_basics;

public class JavaBasicsOperatorsAndNumbers {

    /*
        x=   0, 1, 2, 3,  4,  5,  6,  7,    8,   9,   10,   11,    12,   13
        2^x= 1, 2, 4, 8,  16, 32, 64, 128,  256, 512, 1024, 2048,  4096, 8192

        1           1
        8           100
        33          10 0001
        78          100 1110        78-64=14  14-8=6  6-4=2
        787         11 0001 0011    787-512=275  275-256=19  19-16=3
        33,987      1000 0100 1100 0011

        0010                    2
        1001                    1+8= 9
        0011 0100               4+16+32= 52
        0111 0010               2+16+32+64= 114
        0010 0001 1111          1+2+4+8+16+512= 543
        0010 1100 0110 0111     1+2+4+ 32+64+ 1024+2048 +8192= 11,367
    */

    private static void A() {
        int x = 2; // 10
        System.out.println(Integer.toBinaryString(x));
        x <<= 1; // 100, 4
        System.out.println(Integer.toBinaryString(x) + ", " + x);

        x = 9; // 1001
        System.out.println(Integer.toBinaryString(x));
        x <<= 1; // 10010, 18
        System.out.println(Integer.toBinaryString(x) + ", " + x);

        x = 17; // 10001
        System.out.println(Integer.toBinaryString(x));
        x <<= 1; // 100010, 34
        System.out.println(Integer.toBinaryString(x) + ", " + x);
        
        x = 88; // 1011000
        System.out.println(Integer.toBinaryString(x));
        x <<= 1; // 10110000, 176
        System.out.println(Integer.toBinaryString(x) + ", " + x);
    }

    private static void B() {
        int x = 150; // 10010110
        System.out.println(Integer.toBinaryString(x));
        x >>= 2; // 100101, 37
        System.out.println(Integer.toBinaryString(x) + ", " + x);

        x = 255; // 11111111
        System.out.println(Integer.toBinaryString(x));
        x >>= 2; // 111111, 63
        System.out.println(Integer.toBinaryString(x) + ", " + x);

        x = 1555; // 11000010011
        System.out.println(Integer.toBinaryString(x));
        x >>= 2; // 110000100, 388
        System.out.println(Integer.toBinaryString(x) + ", " + x);

        x = 32456; // 111111011001000
        System.out.println(Integer.toBinaryString(x));
        x >>= 2; // 1111110110010, 8114
        System.out.println(Integer.toBinaryString(x) + ", " + x);
    }

    private static void C() {
        int x = 7, y = 17;
        /*
               00111     7
            &  10001    17
            =  00001     1
        */
        int z = x & y;
        System.out.println(Integer.toBinaryString(z) + ", " + z);
        /*
               00111     7
            |  10001    17
            =  10111    23     
        */
        z = x | y;
        System.out.println(Integer.toBinaryString(z) + ", " + z);
    }

    private static void D() {
        int x = 3;
        System.out.println(x++);
        System.out.println(x);
    }

    private static void E() {
        int x = 3;
        x++;
        System.out.println(x);
        ++x;
        System.out.println(x);
        x += 1;
        System.out.println(x);
    }

    private static void F() {
        int x = 5, y = 8;
        int sum = ++x + y;
        System.out.println(sum); // 14
        x = 5;
        sum = x++ + y;
        System.out.println(sum); // 13
    }

    public static void main(String[] args) {
        A();
        System.out.println();
        B();
        System.out.println();
        C();
        System.out.println();
        D();
        System.out.println();
        E();
        System.out.println();
        F();
    }

}
