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
public class SimpleArraySum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int len=sc.nextInt();
            int[] a=new int[len];
            int sum=0;
            for(int i=0;i<len;i++)
            {
                a[i]=sc.nextInt();
                sum+=a[i];
            }
            System.out.println(sum);
    }

}
