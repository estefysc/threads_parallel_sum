public class LinearSum {
    public int sum(int[] LinearSumNumberArray) {
        int sumTotal = 0;

        for(int i = 0; i < LinearSumNumberArray.length; i++) {
            sumTotal = sumTotal + LinearSumNumberArray[i];
        }

        return  sumTotal;
    } // End of sum
} // End of class LinearSum
