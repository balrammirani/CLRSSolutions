package Hackerrank;

import java.util.Scanner;

/*
 *Incomplete
 * 8/10 testcases
 */
/**
 *
 * @author pulsefire
 */
public class AlmostSorted {

    public static int reverseinitialloc, reversefinalloc;
    public static int swapinitialloc, swapfinalloc;

    /**
     * @param args the command line arguments
     */
    public static boolean isSortable(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSwapable(final int[] arr) {
        int[] copyarr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyarr[i] = arr[i];
        }
        for (int i = 0; i < copyarr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                if (arr.length == 2) {
                    swapinitialloc = i;
                    swapfinalloc = i + 1;
                    int temp = copyarr[i + 1];
                    copyarr[i + 1] = copyarr[i];
                    copyarr[i] = temp;
                    if (!isSortable(copyarr)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    for (int j = i + 1; j < copyarr.length - 1; j++) {

                        if (arr[j] > arr[j + 1]) {
                            //  System.out.println(arr[j] + " " + arr[i]);
                            swapinitialloc = i;
                            swapfinalloc = j + 1;
                            int temp = copyarr[j + 1];
                            copyarr[j + 1] = copyarr[i];
                            copyarr[i] = temp;
                            //  for (int k = 0; k < copyarr.length; k++) {
                            //      System.out.println(copyarr[k]);
                            //  }
                            if (!isSortable(copyarr)) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean isReversible(int[] arr) {
        int[] copyarr = arr;
        int reverselength = 0;
        int initialloc = -1;
        for (int i = 0; i < copyarr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                if (initialloc == -1) {
                    initialloc = i;
                }
                reverselength++;
                for (int j = i + 1; j < copyarr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        reverselength++;
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        reverseinitialloc = initialloc;
        reversefinalloc = initialloc + reverselength;
        int copyinitialloc = initialloc;
        int finalloc = initialloc + reverselength;
        //System.out.println(initialloc);
        for (int k = 0; k < Math.ceil((reverselength) / 2.0); k++) {

            //System.out.println("location=" + copyarr[k] + "," + copyarr[copyarr.length - k - 2]);
            int temp = copyarr[copyinitialloc];
            copyarr[copyinitialloc] = copyarr[finalloc];
            copyarr[finalloc] = temp;
            copyinitialloc++;
            finalloc--;
        }
        //for (int h = 0; h < copyarr.length; h++) {
        //    System.out.println(copyarr[h]);
        // }

        return !isSortable(copyarr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            a[i] = sc.nextInt();
        }
        if (isSortable(a)) {
            if ((isSwapable(a))) {
                System.out.println("yes");
                System.out.println("swap " + (swapinitialloc + 1) + " " + (swapfinalloc + 1));
            } else if (isReversible(a)) {
                System.out.println("yes");
                System.out.println("reverse " + (reverseinitialloc + 1) + " " + (reversefinalloc + 1));

            } else {
                System.out.println("no");
            }
        } else {
            System.out.println("yes");
        }

    }

}
