package Hackerrank;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pulsefire
 */
public class SherlockandSquares {

    /**
     * @param args the command line arguments
     */
    public static long max(long a, long b) {
        return (a > b) ? a : b;
    }

    // A utility funtion to find maximum of three integers
    public static long max(long a, long b, long c) {
        return max(max(a, b), c);
    }

    public static long min(long a, long b) {
        return (a < b) ? a : b;
    }

    // A utility funtion to find maximum of three integers
    public static long min(long a, long b, long c) {
        return min(min(a, b), c);
    }

    // A utility funtion to find maximum of three integers
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        long a;
        long b;
        for (int i = 0; i < size; i++) {
            a = sc.nextLong();
            b = sc.nextLong();

            System.out.println((int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1));
        }
    }
}
