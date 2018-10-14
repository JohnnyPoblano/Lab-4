/*********************************************
**  John G
**  CIS 131
**  Lab 4
*********************************************/

public class Lab4 {

    // Constants
    private static final int ARRAY_SIZE = 10;
    private static final int RAND_LOW = 1;
    private static final int RAND_HIGH = 300;
    private static final int QUIT = 0;
    private static final int ARRAY_1D = 1;
    private static final int ARRAY_2D = 2;

    public static void main(String args[]) { // -------- Main -------------------//

        // Get value from user on which array to use
        int userChoice = getArrayChoice("How many dimensions would you like the array to be?\nPlease enter 1, 2, or 0 to quit.");
        
        while (userChoice != QUIT) { // Start of while-not-sentinel loop

            //--------------------------1D ARRAY ------------------------------------//

            if (userChoice == ARRAY_1D) { // Start of 1D array loop

                System.out.println("********************************************************************************");
                System.out.println("                                    1D ARRAY");
                System.out.println("********************************************************************************\n");

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

                // Get user choice again
                userChoice = getArrayChoice("How many dimensions would you like the array to be?\nPlease enter 1, 2, or 0 to quit.");

            } // End of 1D array loop

            //--------------------------2D ARRAY ------------------------------------//

            if (userChoice == ARRAY_2D) { // Start of 2D array loop

                System.out.println("********************************************************************************");
                System.out.println("                                    2D ARRAY");
                System.out.println("********************************************************************************\n");

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
                System.out.println();

                // Create 1d array for sorting
                int[] sortingArray = new int[ARRAY_SIZE * ARRAY_SIZE];
                
                // For-loop 2d array into new 1d array
                int sortingArrayIndex = 0;
                for (int i = 0; i < my2dArray.length; i++) {
                    for (int j = 0; j < my2dArray[i].length; j++) {
                        sortingArray[sortingArrayIndex] = my2dArray[i][j];
                        sortingArrayIndex++;
                    }
                }

                // Sort 1d array using insertion sort
                sortArray(sortingArray);

                // For-loop 1d array back into 2d array
                int index = 0;
                for (int i = 0; i < ARRAY_SIZE; i++) {
                    for (int j = 0; j < ARRAY_SIZE; j++) {
                        my2dArray[i][j] = sortingArray[index];
                        index++;
                    }
                }

                // Display sorted 2d array
                System.out.println("After the sorting:");
                displayArray(my2dArray);

                // Get user choice again
                userChoice = getArrayChoice("How many dimensions would you like the array to be?\nPlease enter 1, 2, or 0 to quit.");
            
            } // End of 2D array loop 

        } // End of while-not-sentinel loop

        System.out.println("Program ending normally...");

    } // --------------------------------------------- End Main ----------------//

    // Input validation for array selection
    public static int getArrayChoice(String msg) {
        int choice = IR4.getInteger(msg);
        while (choice < QUIT || choice > ARRAY_2D) {
            System.out.println("Error: Please enter a valid integer.");
            choice = IR4.getInteger(msg);
        }

        return choice;
    }
    
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