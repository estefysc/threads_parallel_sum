import java.util.Random;

/**
 * The program uses an array of 200 million random numbers between 1 and 10, and implements a parallel sum and a linear sum to add the numbers and return the total sum.
 * Also, it compares the performance, in milliseconds, between the linear sum, which is a single thread sum, and the parallel sum, which is a multi thread sum.
 *
 * The ParallelSumLauncher contains the main method.
 *
 * @author Estefania G. Sanchez Cabrejos
 * @version 1.0
 * @since 2021-11-17
 */
public class ParallelSumLauncher {

    /**
     * This is the main method, in here the calls to other classes that execute the main logic of the sums are made.
     *
     * @param args
     */
    public static void main(String[] args) {
        int numOfCores = Runtime.getRuntime().availableProcessors();
        int[] randomNumsArray = new int[200000000];

        Random randomGenerator = new Random();
        LinearSum linearSum = new LinearSum();
        ParallelSum parallelSum = new ParallelSum(numOfCores);

        for(int i = 0; i < randomNumsArray.length; i++) {
            randomNumsArray[i] = randomGenerator.nextInt(((10 - 1) + 1) + 1);
        } // End for loop

        long startRunTime = System.currentTimeMillis();
        System.out.println("The total is " + linearSum.sum(randomNumsArray));
        System.out.println("Linear sum takes " + (System.currentTimeMillis() - startRunTime) + " milliseconds.\n");

        startRunTime = System.currentTimeMillis();
        System.out.println("The total is " + parallelSum.sum(randomNumsArray));
        System.out.println("Parallel sum takes " + (System.currentTimeMillis() - startRunTime) + " milliseconds.\n");

        System.out.println("The number of cores is: " + numOfCores);
    }
} // End of class ParallelSumLauncher
