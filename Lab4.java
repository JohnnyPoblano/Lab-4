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

        // Create and display array
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

        //--------------------------2D ARRAY ------------------------------------//

        System.out.println("********************************************************************************");
        System.out.println("                                    2D ARRAY");
        System.out.println("********************************************************************************");

        // Declares 2d array of 10 x 10 ints
        int[][] my2dArray = new int[ARRAY_SIZE][ARRAY_SIZE];

        // Declare vars
        int largest2dIndexR;
        int largest2dIndexC;
        int largest2dValue;
        int smallest2dIndexR;
        int smallest2dIndexC;
        int smallest2dValue;
        int sum2d;
        double average2d;

        // Create and display array
        populateArray(my2dArray);
        System.out.println("Before the Sorting:");
        displayArray(my2dArray);

        // Calculate largest
        largest2dIndexR = getLargeIndexR(my2dArray);
        largest2dIndexC = getLargeIndexC(my2dArray);
        largest2dValue = my2dArray[largest2dIndexR][largest2dIndexC];

        // Calculate smallest
        smallest2dIndexR = getSmallIndexR(my2dArray);
        smallest2dIndexC = getSmallIndexC(my2dArray);
        smallest2dValue = my2dArray[smallest2dIndexR][smallest2dIndexC];

        // Sum/Average
        sum2d = calculateSum(my2dArray);
        average2d = calculateAverage2d(sum2d);

        // Display Calculations
        displayCalculations(largest2dIndexR, largest2dIndexC, largest2dValue, smallest2dIndexR, smallest2dIndexC, smallest2dValue, sum2d, average2d);


    } // --------------------------------------------- End Main ----------------//

    
    // Display array elements with single space between elements
    public static void displayArray(int[] array) {
        System.out.println("********************************************************************************");
        System.out.println("Array Elements");
        System.out.println("********************************************************************************");
        
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }

        System.out.println();
        System.out.println();
    }

    //2d displayArray
    public static void displayArray(int[][] array) {
        System.out.println("********************************************************************************");
        System.out.println("Array Elements");
        System.out.println("********************************************************************************");
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%-5d", array[i][j]);
            }

            System.out.println();
        }

        System.out.println();
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
        System.out.println();
    }

    // 2d displayCalculations
    public static void displayCalculations(int lIndexR, int lIndexC, int lValue, int sIndexR, int sIndexC, int sValue, int sum, double avg) {
        System.out.println("********************************************************************************");
        System.out.println("Results of Array Processing");
        System.out.println("********************************************************************************");
        System.out.println("The index of the highest value is [" + lIndexR + "][" + lIndexC + "]. Its value is " + lValue + ".");
        System.out.println("The index of the smallest value is [" + sIndexR + "][" + sIndexC + "]. Its value is " + sValue + ".");
        System.out.println("The sum of the array elements is " + sum + ".");
        System.out.println("The average of the array elements is " + avg + ".");
    }
    
    // Populate array with random nums (1-300)
    public static void populateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = IR4.getRandomNumber(RAND_LOW, RAND_HIGH);
        }
    }

    // 2d populateArray
    public static void populateArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = IR4.getRandomNumber(RAND_LOW, RAND_HIGH);
            }
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

    // 2d getLargeIndex (row)
    public static int getLargeIndexR(int[][] array) {
        
        int largestIndexR = 0;
        int largestIndexC = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > array[largestIndexR][largestIndexC]) {
                    largestIndexR = i;
                    largestIndexC = j;
                }
            }
        }

        return largestIndexR;
    }

    // 2d getLargeIndex (column)
    public static int getLargeIndexC(int[][] array) {
        
        int largestIndexR = 0;
        int largestIndexC = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > array[largestIndexR][largestIndexC]) {
                    largestIndexR = i;
                    largestIndexC = j;
                }
            }
        }

        return largestIndexC;
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

    // 2d getSmallIndex (row)
    public static int getSmallIndexR(int[][] array) {
        
        int smallIndexR = 0;
        int smallIndexC = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < array[smallIndexR][smallIndexC]) {
                    smallIndexR = i;
                    smallIndexC = j;
                }
            }
        }

        return smallIndexR;
    }

    // 2d getSmallIndex (column)
    public static int getSmallIndexC(int[][] array) {
        
        int smallIndexR = 0;
        int smallIndexC = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < array[smallIndexR][smallIndexC]) {
                    smallIndexR = i;
                    smallIndexC = j;
                }
            }
        }

        return smallIndexC;
    }

    // Calculate sum of elements
    public static int calculateSum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

    // 2d calculateSum
    public static int calculateSum(int[][] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }

        return sum;
    }

    // Calculate average of elements
    public static double calculateAverage(int sum) {
        double avg = (double) sum / ARRAY_SIZE;
        return avg;
    }

    // 2d calculate average
    public static double calculateAverage2d(int sum) {
        double avg = (double) sum / (ARRAY_SIZE * ARRAY_SIZE);
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