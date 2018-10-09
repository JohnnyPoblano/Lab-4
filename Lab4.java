/*
**  John G
**  CIS 131
**  Lab 4
*/

public class Lab4 {

    // Constants
    private static final int ARRAY_SIZE = 10;
    private static final int RAND_LOW = 1;
    private static final int RAND_HIGH = 300;

    public static void main(String args[]) { // -------- Main -------------------//

        // Declares an array of 10 ints
        int[] myArray = new int[ARRAY_SIZE];

        // Declare vars
        int largestIndex;
        int largestValue;
        int smallestIndex;
        int smallestValue;
        int sum;
        double average;

        // Processing
        populateArray(myArray);
        System.out.println("Before the Sorting:");
        displayArray(myArray);

        // Calculate smallest/largest index
        largestIndex = getLargeIndex(myArray);
        largestValue = myArray[largestIndex];
        smallestIndex = getSmallIndex(myArray);
        smallestValue = myArray[smallestIndex];

        // Calculate sum/average
        sum = calculateSum(myArray);
        average = calculateAverage(sum);

        // Display calculations
        displayCalculations(largestIndex, largestValue, smallestIndex, smallestValue, sum, average);

        // Sort then display array
        sortArray(myArray);
        System.out.println("After the sorting:");
        displayArray(myArray);

    } // --------------------------------------------- End Main ----------------//

    
    // Display array elements with single space between elements
    public static void displayArray(int[] array) {
        System.out.println("********************************************************************************");
        System.out.println("Array Elements");
        System.out.println("********************************************************************************");
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

    }

    // Display calculations
    public static void displayCalculations(int lIndex, int lValue, int sIndex, int sValue, int sum, double avg) {
        System.out.println("********************************************************************************");
        System.out.println("Results of Array Processing");
        System.out.println("********************************************************************************");
        System.out.println("The index of the highest value is " + lIndex + ". Its value is " + lValue + ".");
        System.out.println("The index of the lowest value is " + sIndex + ". Its value is " + sValue + ".");
        System.out.println("The sum of the array elements is " + sum + ".");
        System.out.println("The average of the array elements is " + avg + ".");
    }
    
    // Populate array with random nums (1-300)
    public static void populateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = IR4.getRandomNumber(RAND_LOW, RAND_HIGH);
        }
    }

    // Determine index of largest number in the array
    public static int getLargeIndex(int[] array) {
        
        int largeIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[largeIndex]) {
                largeIndex = i;
            }
        }

        return largeIndex;
    }

    // Determine index of smallest number in the array
    public static int getSmallIndex(int[] array) {
        
        int smallIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[smallIndex]) {
                smallIndex = i;
            }
        }

        return smallIndex;
    }

    // Calculate sum of elements
    public static int calculateSum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

    // Calculate average of elements
    public static double calculateAverage(int sum) {
        double avg = (double) sum / ARRAY_SIZE;
        return avg;
    }

    // Insertion sort method
    public static void sortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];
            int k;
            for (k = i - 1; k >= 0 && array[k] > currentElement; k--) {
                array[k + 1] = array[k];
            }
            array[k+1] = currentElement;
        }
    }

}