package Hackerrank;

/**
 *
 * @author pulsefire
 */
public class MaximumSubArray {

    //*********************************
    //Divide and Conquer Approach
    //Complexity: O(n logn)
    //*********************************
    // A utility funtion to find maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility funtion to find maximum of three integers
    int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    // Find the maximum possible sum in arr[] auch that arr[m] is part of it
    //This will handle max sum when part of data resides in left subarray and part of it resides in rightsubarray
    int maxCrossingSum(int arr[], int l, int m, int h) {
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
    int maxSubArraySum(int arr[], int l, int h) {
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

    /**
     * Brute Force Approach ::: Complexity: O(n^2) ::: Find a sequence of days
     * over which the net change from the first day to the last is maximum
     *
     * @param arr
     * @return
     */
    public int brute_maxsubarray(int[] arr) {
        int current = 0, j, max = 0;
        //Start day
        for (int i = 0; i < arr.length; i++) {

            current = 0;
            //End Day Loop
            //End should be greater than start day,hence j is seeded with i as initial value
            for (j = i; j < arr.length; j++) {
                current += arr[j];
                //System.out.println(current);
                if (current > max) {
                    max = current;
                }
            }
            //System.out.println("Max="+max+"i="+arr[i]);
        }
        return max;
    }

    /**
     * Kadane's Approach ::: Complexity: O(n) ::: This algorithm just goes
     * through the loop, continuously changing the current maximum sum. This
     * algorithm assumes that array contains atleast 1 positive value
     *
     * @param arr
     * @return max value
     */
    public int kadane_maxsubarray(int[] arr) {
        int max = 0, maxcurrent = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + maxcurrent > 0) {
                maxcurrent += arr[i];
            } else {
                maxcurrent = 0;
            }
            max = Math.max(max, maxcurrent);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};//Considered example stated in CLRS page 70
        int n = arr.length;
        MaximumSubArray ds = new MaximumSubArray();
        int max_sum;
        max_sum = ds.brute_maxsubarray(arr);
        System.out.println("Maximum contiguous sum from Brute Force is=" + max_sum); //the output should be 43 (from index 8-11)

        max_sum = ds.maxSubArraySum(arr, 0, n - 1);
        System.out.println("Maximum contiguous sum from Divide and Conquer is=" + max_sum); //the output should be 43 (from index 8-11)

        max_sum = ds.kadane_maxsubarray(arr);
        System.out.println("Maximum contiguous sum from Kadane's is=" + max_sum); //the output should be 43 (from index 8-11)

    }

}
