/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hackerrank;

import java.util.Scanner;

/**
 *
 * @author pulsefire
 */
public class SherlockandArray_Left_Right_EqualArray {

    /**
     * @param args the command line arguments
     */
    public static boolean chkLeftRightArraySum(int arraySum, int arr[]) {
        int leftSum = 0, rightSum = 0;
        rightSum = arraySum ;
        for (int j = 0; j < arr.length; j++) {
            if (leftSum == (rightSum - arr[j])) {
                return true;
            } else {
                leftSum += arr[j];
                rightSum -= arr[j];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfIterations = sc.nextInt();
        int arraySize;
        int arraySum;
        for (int i = 0; i < noOfIterations; i++) {
            arraySum=0;
            arraySize = sc.nextInt();
            int[] arr = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                arr[j] = sc.nextInt();
                arraySum += arr[j];
            }
            if (chkLeftRightArraySum(arraySum, arr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
