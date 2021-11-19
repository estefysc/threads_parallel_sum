/**
 * The ParallelSum class implements a sum that is executed in a linear fashion. However, the array provided is first divided in the amount of threads available to the processor.
 * Each thread will linearly add a certain amount of numbers; a piece of the array. Then, each subtotal will be added later to return a total sum.
 * This class contains a constructor and one method:
 *      public ParallelSum(int threads)
 *      public int sum(int[] parallelSumNumberArray)
 *
 * @author Estefania G. Sanchez Cabrejos
 * @version 1.0
 * @since 2021-11-17
 */
public class ParallelSum {
    private ParallelHelper[] workingThread;
    private int numberOfThreads;

    /**
     * Provides the number of threads and the number of ParallelHelpers that will be in charge of adding one piece of the entire array.
     *
     * @param threads   Number of cores available.
     */
    public ParallelSum(int threads) {
        this.numberOfThreads = threads;
        this.workingThread = new ParallelHelper[numberOfThreads];
    } // End of constructor

    /**
     * Divides the array in the amount of cores available; there will be as many threads as available cores. Each thread then adds the numbers contained in a piece of the
     * array. Uses the {@link #getPartialSum()} method from the ParallelHelper class to execute the actual sum.
     *
     * @param parallelSumNumberArray    A 200 million random number array between 1 and 10.
     * @return                          An int; the total result of the sum.
     */
    public int sum(int[] parallelSumNumberArray) {
        int sumTotal = 0;
        // todo - Math.ceil - java.lang.ArrayIndexOutOfBoundsException is thrown when array has an odd amount of numbers.
        int numbersPerThread = (int)Math.ceil((parallelSumNumberArray.length * 1.0) / numberOfThreads);

        // This for loop provides the low index and high index to each thread.
        for(int i = 0; i < numberOfThreads; i++) {
            workingThread[i] = new ParallelHelper(parallelSumNumberArray, i * numbersPerThread, (i + 1) * numbersPerThread);
            workingThread[i].start();
        }

        try {
            for (ParallelHelper helper : workingThread) {
                helper.join();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        for(ParallelHelper helper : workingThread) {
            sumTotal = sumTotal + helper.getPartialSum();
        }

        return sumTotal;
    } // End of sum
} // End of class Sum
