public class ParallelSum {
    private ParallelHelper[] workingThread;
    private int numberOfThreads;

    public ParallelSum(int threads) {
        this.numberOfThreads = threads;
        // new ParallelHelper[numberOfThreads] creates the amount of workingThreads needed.
        this.workingThread = new ParallelHelper[numberOfThreads];
    } // End of constructor

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
