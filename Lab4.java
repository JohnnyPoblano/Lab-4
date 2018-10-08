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
        int[] array = new int[ARRAY_SIZE];

        // Declare vars
        int largeIndex;
        int largeValue;
        int smallIndex;
        int smallValue;
        int sum;
        double average;

    } // --------------------------------------------- End Main ----------------//

    
    // Populate array with random nums (1-300)
    public static void populateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = IR4.getRandomNumber(RAND_LOW, RAND_HIGH);
        }
    }

}