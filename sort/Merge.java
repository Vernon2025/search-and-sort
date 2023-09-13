package sort;

import java.util.Arrays;

/**
 * Write a description of class Merge here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Merge {

    /**
     * Returns the sorted array
     */
    public static int[] sort(int[] arr) {
        // Base case: If the array has 0 or 1 elements, it is already sorted.
        if (arr.length <= 1) {
            return arr;
        }
    
        // Find the middle index of the array.
        int mid = arr.length / 2;
    
        // Create two subarrays, 'left' and 'right', by splitting the original array in half.
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
    
        // Recursively sort the 'left' and 'right' subarrays.
        left = sort(left);
        right = sort(right);
    
        // Merge the sorted 'left' and 'right' subarrays into a single sorted array.
        int[] merged = new int[arr.length];
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
    
        // Compare elements from 'left' and 'right' and merge them in sorted order.
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                merged[mergedIndex] = left[leftIndex];
                leftIndex++;
            } else {
                merged[mergedIndex] = right[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }
    
        // Copy any remaining elements from 'left' into the merged array.
        while (leftIndex < left.length) {
            merged[mergedIndex] = left[leftIndex];
            leftIndex++;
            mergedIndex++;
        }
    
        // Copy any remaining elements from 'right' into the merged array.
        while (rightIndex < right.length) {
            merged[mergedIndex] = right[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
    
        // Return the merged and sorted array.
        return merged;
    }

    public static void main(String[] args) {
        int[] arr = {53, 85, 93, 25, 39, 27, 42, 5, 24, 45, 33, 51, 5, 80, 4, 7, 91,
                31, 66, 71, 32, 19, 79, 58, 61, 82, 89, 63, 7, 4, 50, 10, 48, 24, 75, 19, 22,
                73, 54, 51, 25, 33, 20, 52, 79, 97, 70, 54, 63, 49};

        // Test the sort
        testSort(sort(arr));
    }

    public static void testSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("FAIL at index " + i);
                System.out.println(Arrays.toString(arr));
                return;
            }
        }
        System.out.println("SUCCESS!");
    }
}
