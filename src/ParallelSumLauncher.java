/**
 * Implement a parallel array sum, and compare performance with single thread sum.
 *
 * Make an array of 200 million random numbers between 1 and 10. Compute the sum in parallel using multiple threads.
 * Then compute the sum with only one thread, and display the sum and times for both cases.
 */

import java.util.Random;

public class ParallelSumLauncher {
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
