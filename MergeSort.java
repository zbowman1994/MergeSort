public class MergeSort {
   public static void merge(int numbers [], int start, int j, int end) {
      int mergedSize = end - start + 1;       // Size of merged partition
      int mergedNumbers [] = new int[mergedSize]; // Temporary array for merged numbers
      int mergePos = 0;                 // Position to insert merged number
      int leftPos = 0;                  // Position of elements in left partition
      int rightPos = 0;                 // Position of elements in right partition

      leftPos = start;                      // Initialize left partition position
      rightPos = j + 1;                 // Initialize right partition position

      // Add smallest element from left or right partition to merged numbers
      while (leftPos <= j && rightPos <= end) {
         if (numbers[leftPos] < numbers[rightPos]) {
            mergedNumbers[mergePos] = numbers[leftPos];
            ++leftPos;
         } 
         else {
            mergedNumbers[mergePos] = numbers[rightPos];
            ++rightPos;
         }
         ++mergePos;
      }

      // If left partition is not empty, add remaining elements to merged numbers
      while (leftPos <= j) {
         mergedNumbers[mergePos] = numbers[leftPos];
         ++leftPos;
         ++mergePos;
      }

      // If right partition is not empty, add remaining elements to merged numbers
      while (rightPos <= end) {
         mergedNumbers[mergePos] = numbers[rightPos];
         ++rightPos;
         ++mergePos;
      }

      // Copy merge number back to numbers
      for (mergePos = 0; mergePos < mergedSize; ++mergePos) {
         numbers[start + mergePos] = mergedNumbers[mergePos];
      }
   }

   public static void mergeSort(int numbers[], int start, int end) {
      int j = 0;
	  System.out.println("HI " + start + end);

      if (start < end) {
         j = (start + end) / 2;  // Find the midpoint in the partition
		 System.out.println("In the recursive loop now for i and k");

         // Recursively sort left and right partitions
         mergeSort(numbers, start, j);
         mergeSort(numbers, j + 1, end);

         // Merge left and right partition in sorted order
         merge(numbers, start, j, end);
      }
   }

   public static void main(String [] args) {
      int numbers [] = {10, 2, 78, 4, 45, 32, 7, 11};
      final int NUMBERS_SIZE = 8;
      int i = 0;

      System.out.print("UNSORTED: ");
      for (i = 0; i < NUMBERS_SIZE; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();

      /* initial call to quicksort with index */
      mergeSort(numbers, 0, NUMBERS_SIZE - 1);

      System.out.print("SORTED: ");
      for (i = 0; i < NUMBERS_SIZE; ++i) {
         System.out.print(numbers[i] + " ");
      }
      System.out.println();

      return;
   }
}