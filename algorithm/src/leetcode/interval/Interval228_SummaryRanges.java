package leetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class Interval228_SummaryRanges {

    /*
        숫자가 연속되면 a -> b
        다음값과 같다면 그냥 a
        이어지지 않으면 그냥 a
     */
    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();

        if(nums.length == 0) return ans;
        if(nums.length == 1) {

            ans.add(String.valueOf(nums[0]));
            return ans;
        };

        StringBuilder sb = new StringBuilder();
        int start = nums[0];

        for(int x = 1; x < nums.length; x++) {

            int cur = nums[x];
            int bef = nums[x - 1];

            if(cur == bef) {

                sb.append(cur);
                ans.add(sb.toString());
                sb.setLength(0);
                if(x == nums.length - 1) {
                    break;
                }

                start = nums[x + 1];

                continue;
            }

            if(cur - bef != 1) {

                if(start == bef) sb.append(bef);
                else sb.append(start).append("->").append(bef);

                ans.add(sb.toString());
                sb.setLength(0);
                start = cur;
            }

            if(x == nums.length - 1) {

                if(start == cur) sb.append(cur);
                else sb.append(start).append("->").append(cur);

                ans.add(sb.toString());
            }

        }

        return ans;

    }

}
