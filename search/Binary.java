package search;

import sort.Merge;

/**
 * Write a description of class Binary here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Binary {

  /**
   * Returns the index of the target value, or -1 if not found
   */
  public static int search(int[] arr, int target) {
    // Initialize the left and right pointers to the start and end of the array.
    int left = 0;
    int right = arr.length - 1;

    // Continue searching as long as the left pointer is less than or equal to the right pointer.
    while (left <= right) {
        // Calculate the middle index of the current search range.
        int mid = (left + right) / 2;

        // Check if the middle element is equal to the target.
        if (arr[mid] == target) {
            // If a match is found, return the index of the target element.
            return mid;
        } else if (arr[mid] < target) {
            // If the middle element is less than the target, update the left pointer
            // to search the right half of the current range.
            left = mid + 1;
        } else {
            // If the middle element is greater than the target, update the right pointer
            // to search the left half of the current range.
            right = mid - 1;
        }
    }

    // If the loop completes without finding the target, return -1 to indicate it was not found.
    return -1;
}


  public static void main(String[] args) {
    int[] arr = { 53, 85, 93, 25, 39, 27, 42, 5, 24, 45, 33, 51, 5, 80, 4, 7, 91,
        31, 66, 71, 32, 19, 79, 58, 61, 82, 89, 63, 7, 4, 50, 10, 48, 24, 75, 19, 22,
        73, 54, 51, 25, 33, 20, 52, 79, 97, 70, 54, 63, 49 };

    // Remember that a binary search requires a sorted array!
    // You can use one of your sorting methods here.
    Merge.sort(arr);
    ////////////////////////////////////////////////////////////
    // Do not change anything below this line!!
    ////////////////////////////////////////////////////////////
    boolean isSorted = true;
    for (int i = 0; i < arr.length - 1 && isSorted; i++) {
      if (arr[i] > arr[i + 1]) {
        isSorted = false;
      }
    }
    printResult("Is sorted?", isSorted);
    printResult(82, search(arr, 82) == 44); // Find index in unsorted or sorted array
    printResult(49, search(arr, 49) == 24);
    printResult(-4, search(arr, -4) == -1);
  }

  public static void printResult(int target, boolean result) {
    System.out.println("Search for " + target + ": " + ((result) ? "CORRECT" : "INCORRECT"));
  }

  public static void printResult(String target, boolean result) {
    System.out.println(target + ": " + ((result) ? "CORRECT" : "INCORRECT"));
  }

}
