package jcp;

public class MaximumSumSubarray {

    public static int findMaxSubSum(int[] arr) {
        if ( arr.length == 0) {
            return 0; // Handling empty array case
        }
        int maxSum = arr[0];
        int maxCurrentSum = arr[0];

        for ( int i = 1; i < arr.length; i++ ) {
          maxCurrentSum = Math.max(arr[i], maxCurrentSum + arr[i]); // Update maxCurrentSum to be the maximum between the current element and maxCurrentSum so far
          maxSum = Math.max(maxSum, maxCurrentSum); // / Update maxSum to be the maximum value
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum sum subarray: " + findMaxSubSum(arr)); // Expected outcome 6
    }
}


