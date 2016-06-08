/*
 You are given two strings, A and B. Find if there is a substring that appears in both A and B.

 Input Format

 Several test cases will be given to you in a single file. The first line of the input will contain a single integer T, the number of test cases.

 Then there will be T descriptions of the test cases. Each description contains two lines. The first line contains the string A and the second line contains the string B.

 Output Format

 For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.


 Sample Input

 2
 hello
 world
 hi
 world

 Sample Output

 YES
 NO

 Explanation

 For the 1st test case, the letter o is common between both strings, hence the answer YES. (Furthermore, the letter l is also common, but you only need to find one common substring.) 
 For the 2nd test case, hi and world do not have a common substring, hence the answer NO.
 */
package Hackerrank;

import java.util.Scanner;

/**
 *
 * @author pulsefire
 */
public class TwoStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfIterations = sc.nextInt();
        for (int j = 0; j < noOfIterations; j++) {
            String string1 = sc.next();
            String string2 = sc.next();
            int[] charArray1 = new int[26];
            int[] charArray2 = new int[26];

            for (int i = 0; i < string1.length(); i++) {
                charArray1[(int) string1.charAt(i) - 97]++;
            }
            for (int i = 0; i < string2.length(); i++) {
                charArray2[(int) string2.charAt(i) - 97]++;
            }
            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                if (charArray1[i] != 0 && charArray2[i] != 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

}
