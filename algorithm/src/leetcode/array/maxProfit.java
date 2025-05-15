package leetcode.array;

public class maxProfit {

     /*
        1 <= prices.length <= 3 * 104
        0 <= prices[i] <= 104
    */

    public int maxProfit(int[] prices) {

        int max = 0;

        for(int i =1; i < prices.length; i ++) {

            if(prices[i] > prices[i - 1]) {
                max = max + (prices[i] - prices[i - 1]);
            }
        }

        return max;

    }

}
