package DivideandConquer;

/**
 *
 * @author pulsefire
 */
public class MaximumSubArray {
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

    public static void main(String[] args) {
        int arr[] = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};//Considered example stated in CLRS page 70
        int n = arr.length;
        MaximumSubArray ds = new MaximumSubArray();
        int max_sum = ds.maxSubArraySum(arr, 0, n - 1);
        System.out.println("Maximum contiguous sum is=" + max_sum); //the output should be 43 (from index 8-11)
    }

}
