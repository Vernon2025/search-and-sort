package sort;

import java.util.Arrays;

/**
 * Write a description of class Insertion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Insertion
{

    /**
     * Returns the sorted array
     */
    public static int[] sort(int[] arr) {
        // Your algorithm goes here!
        int n = arr.length;  // Get the length of the input array.
    
        // Start iterating through the array from the second element (index 1).
        for (int i = 1; i < n; i++) {
            int k = arr[i];  // Store the current element in 'k'.
            int j = i - 1;   // Initialize 'j' to the index before 'i'.
    
            // This inner loop is used to find the correct position for 'k'
            // within the sorted part of the array.
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];  // Shift the larger element one position to the right.
                j--;                 // Move 'j' leftwards in the sorted part of the array.
            }
    
            arr[j + 1] = k;  // Insert 'k' in its correct sorted position.
        }
        
        return arr;  // Return the sorted array.
    }
    

    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};    

        // Test the sort
        testSort(sort(arr));
    }

    public static void testSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.println("FAIL at index "+i);
                System.out.println(Arrays.toString(arr));
                return;
            }
        }
        System.out.println("SUCCESS!");
    }

}
