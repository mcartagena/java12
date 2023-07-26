package com.mcartagena.datastructure.divideandconquer;

import java.util.Arrays;

public class MaximumSubarray {

    public static int[] findCrossingSubArray(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for (int i = mid; i >= 0; i--) {
            sum = sum + arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        int maxRight = mid;
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + arr[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = j;
            }
        }
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }

    public static int[] findMaximumSubArray(int[] arr, int low, int high) {
//        System.out.println(low);
        if (low == high) {
            return new int[]{low, high, arr[low]};
        } else {
            int mid = (low + high) / 2;
            int[] leftResult = findMaximumSubArray(arr, low, mid);
            int[] rightResult = findMaximumSubArray(arr, mid + 1, high);
            int[] crossResult = findCrossingSubArray(arr, low, mid, high);
            if (leftResult[2] >= rightResult[2] && leftResult[2] >= crossResult[2]) {
                return leftResult;
            } else if (rightResult[2] >= leftResult[2] && rightResult[2] >= crossResult[2]) {
                return rightResult;
            } else {
                return crossResult;
            }
        }

    }

    public static void main(String[] args) {
        int[] stockChange = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] result = findMaximumSubArray(stockChange, 0, stockChange.length - 1);
        System.out.println(Arrays.toString(result));
        System.out.println("The result is:");
        for(int i = result[0]; i<= result[1];i++){
            System.out.print(stockChange[i]+", ");
        }
    }
}
