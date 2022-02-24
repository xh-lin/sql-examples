package com.perscholas.java_basics;

import java.util.Arrays;

public class JavaBasicsArrays {

    static void a() {
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(arr));
    }

    static void b() {
        int[] arr = {13,5,7,68,2};
        System.out.println(arr[arr.length/2]);
    }

    static void c() {
        String[] colors = {"red", "green", "blue", "yellow"};
        System.out.println(colors.length);
        String[] newColors = colors.clone();
        System.out.println(Arrays.toString(newColors));
    }

    static void d() {
        int[] arr = {1,2,3,4,5};
        System.out.println(arr[0] + ", " + arr[arr.length-1]);
        try {
            System.out.println(arr[arr.length]);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(arr[5]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void e() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
        System.out.println(Arrays.toString(arr));
    }

    static void f() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i * 2;
        System.out.println(Arrays.toString(arr));
    }

    static void g() {
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length/2) continue;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void swap(Object[] arr, int a, int b) {
        Object tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void h() {
        String[] arr = {"aa", "bb", "cc", "dd", "ee"};
        System.out.println(Arrays.toString(arr));
        int mid = arr.length/2;
        swap(arr, 0, mid);
        System.out.println(Arrays.toString(arr));
    }

    // bubble sort O(n^2)
    private static void sort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                    swap(arr, j, j+1);
    }

    static void i() {
        Integer[] arr = {4, 2, 9, 13, 1, 0};
        sort(arr);
        System.out.println("Array in ascending order: " + Arrays.toString(arr));
        System.out.println("The smallest number is " + arr[0]);
        System.out.println("The biggest number is " + arr[arr.length - 1]);
    }

    static void j() {
        Object[] arr = {123, "abc", 1.23d};
        System.out.println(Arrays.toString(arr));
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
        j();
    }

}