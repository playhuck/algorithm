package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Array1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for(int candy : candies) {

            max = Math.max(max, candy);
        };

        for(int candy : candies) {

            int extraCandy = candy + extraCandies;

            if(extraCandy >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

}
