package leetcode.array;

import java.util.PriorityQueue;

public class Array121 {
    public int maxProfit(int[] prices) {

        int len = prices.length;
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (arr1, arr2) -> arr2[0] - arr1[0]
        );

        for(int i =0; i < len - 1; i ++) {

            for(int j = i + 1; j < len; j ++) {

                int cal = prices[j] - prices[i];
                if(cal <= 0) continue;

                if(cal >= max) {
                    q.add(new int[]{cal, prices[j], prices[i]});
                    max = cal;
                }
            }
        }

        return max == Integer.MIN_VALUE ? 0 : q.peek()[1] - q.peek()[2];
    }

    /*
        최대 이윤을 얻는 날을 골라야 합니다. 두 차가 가장 큰 값을 골라야 하는데
        여기서 더 인덱스가 낮은 값이 작은 값이어야 하고, 인덱스가 큰 값이 높은 값이어야 합니다.
        차가 항상 같다면 최대 이윤을 얻는날이 없기 때문에 0을 리턴합니다.
        1. 차가 가장 큰 값 중 left - right가 음수가 되는 값을 선택합니다.
        2. 가장 싼 날에 구매해서 가장 비싼날에 판매하는 코드를 구성해야 합니다.
    */
    public int maxProfit2(int[] prices) {

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices) {

            if(price < min) min = price;

            if(price > min) profit = Math.max(profit, price - min);
        }

        return profit;
    }
}
