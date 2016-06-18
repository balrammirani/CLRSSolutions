/*
 Given an array  of N elements, find the maximum possible sum of a

Contiguous subarray
Non-contiguous (not necessarily contiguous) subarray.
Empty subarrays/subsequences should not be considered.

Input Format

First line of the input has an integer T. T cases follow. 
Each test case begins with an integer N. In the next line,N  integers follow representing the elements of array A.

Constraints:

The subarray and subsequences you consider should have at least one element.

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

Sample Input

2 
4 
1 2 3 4
6
2 -1 2 3 4 -5
Sample Output

10 10
10 11
Explanation

In the first case: 
The max sum for both contiguous and non-contiguous elements is the sum of ALL the elements (as they are all positive).

In the second case: 
[2 -1 2 3 4] --> This forms the contiguous sub-array with the maximum sum. 
For the max sum of a not-necessarily-contiguous group of elements, simply add all the positive elements.
 */
package Hackerrank;

import java.util.Scanner;

/**
 *
 * @author pulsefire
 */
public class TheMaximumSubArray_Cont_NonCont_Array {

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility funtion to find maximum of three integers
    public static int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    // Find the maximum possible sum in arr[] auch that arr[m] is part of it
    //This will handle max sum when part of data resides in left subarray and part of it resides in rightsubarray
    public static int maxCrossingSum(int arr[], int l, int m, int h) {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {  //As we are considering the middle chunk,starting index is set to mid and gradually decreasing till low
            sum = sum + arr[i];
            if (sum > left_sum) {
                left_sum = sum;
            }
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum) {
                right_sum = sum;
            }
        }

        // Return sum of elements on left and right of mid
        return left_sum + right_sum;
    }

    // Returns sum of maxium sum subarray in arr[l..h]
    public static int maxSubArraySum(int arr[], int l, int h) {
        // Base Case: Only one element
        if (l == h) {
            return arr[l];
        }

        // Find middle point
        int m = (l + h) / 2;

        /* Return maximum of following three possible cases
         a) Maximum subarray sum in left half
         b) Maximum subarray sum in right half
         c) Maximum subarray sum such that the subarray crosses the midpoint */
        return max(maxSubArraySum(arr, l, m),
                maxSubArraySum(arr, m + 1, h),
                maxCrossingSum(arr, l, m, h));
    }

    public static int maxNonContSubArraySum(int arr[], int maxCont) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maxCont || arr[i] > 0) {
                if (sum == Integer.MIN_VALUE) {
                    sum = 0;
                }
                sum += arr[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfIterations = sc.nextInt();
        int arraySize;
        for (int i = 0; i < noOfIterations; i++) {
            arraySize = sc.nextInt();
            int[] arr = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                arr[j] = sc.nextInt();
            }
            //int[] arr = new int[]{-1, -3, -5, -7};
            int maxCont = maxSubArraySum(arr, 0, arraySize - 1);
            int maxNonCont = maxNonContSubArraySum(arr, maxCont);
            System.out.println(maxCont + " " + maxNonCont);
        }
    }

}
