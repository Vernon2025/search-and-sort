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
        // If the array has 1 or 0 elements, it is already sorted.
        if (arr.length <= 1) {
            return arr;
        }

        // Split the array into two halves
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort the left and right halves
        left = sort(left);
        right = sort(right);

        // Merge the sorted halves
        return merge(left, right);
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

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        
        // Compare elements from both arrays and merge them in sorted order
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        
        // Copy any remaining elements from left and right arrays
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }
}
