/**
 * The ParallelHelper class assigns a partial sum to each thread.
 * This class contains a constructor and one method
 *      public ParallelHelper(int[] nums, int low, int high)
 *      public int getPartialSum()
 *
 *  @author Estefania G. Sanchez Cabrejos
 *  @version 1.0
 *  @since 2021-11-17
 */
public class ParallelHelper extends Thread{
    private int[] parallelHelperNumberArray;
    private int parallelHelperLowIndex;
    private int parallelHelperHighIndex;
    private int partialSum;

    /**
     * Provides the main array, a low index, and a high index.
     *
     * @param nums  The main 200 million random number array.
     * @param low   A low index used to mark the beginning of a portion of the array.
     * @param high  A high index used to mark the end of a portion of the array.
     */
    public ParallelHelper(int[] nums, int low, int high) {
        this.parallelHelperNumberArray = nums;
        this.parallelHelperLowIndex = low;
        this.parallelHelperHighIndex = high;
    } // End of constructor

    /**
     * Obtains and returns the partial sum.
     *
     * @return An int representing the sum of a portion of the main array.
     */
    public int getPartialSum() {
        return this.partialSum;
    } // End of getPartialSum


    /**
     * Executes a linear sum of a piece of the main array.
     */
    @Override
    public void run() {
        partialSum = 0;

        for(int i = parallelHelperLowIndex; i < parallelHelperHighIndex; i++) {
            partialSum = partialSum + parallelHelperNumberArray[i];
        }
    } // End of run

} // End of ParallelHelper class
