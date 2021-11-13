public class ParallelHelper extends Thread{
    private int[] parallelHelperNumberArray;
    private int parallelHelperLowIndex;
    private int parallelHelperHighIndex;
    private int partialSum;

    public ParallelHelper(int[] nums, int low, int high) {
        this.parallelHelperNumberArray = nums;
        this.parallelHelperLowIndex = low;
        this.parallelHelperHighIndex = high;
    } // End of constructor

    public int getPartialSum() {
        return this.partialSum;
    } // End of getPartialSum

    @Override
    public void run() {
        partialSum = 0;

        for(int i = parallelHelperLowIndex; i < parallelHelperHighIndex; i++) {
            partialSum = partialSum + parallelHelperNumberArray[i];
        }
    } // End of run
} // End of ParallelHelper class
