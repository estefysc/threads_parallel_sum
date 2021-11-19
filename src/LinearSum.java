/**
 * The LinearSum class implements a sum that is executed in a linear fashion. That is, number by number in a consecutive manner.
 * This class contains only one method: public int sum(int[] LinearSumNumberArray).
 *
 * @author Estefania G. Sanchez Cabrejos
 * @version 1.0
 * @since 2021-11-17
 */
public class LinearSum {

    /**
     * Adds the numbers contained in the array passed as a parameter in a linear fashion using only one thread.
     *
     * @param LinearSumNumberArray  A 200 million random number array between 1 and 10.
     * @return                      An int; the total result of the sum.
     */
    public int sum(int[] LinearSumNumberArray) {
        int sumTotal = 0;

        for(int i = 0; i < LinearSumNumberArray.length; i++) {
            sumTotal = sumTotal + LinearSumNumberArray[i];
        }

        return  sumTotal;
    } // End of sum
} // End of class LinearSum
