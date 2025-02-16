package leetcode.heap;

import java.util.*;

public class Heap2231_LargestNumberAfterDigitSwapsByParity {
    /*
        양의 정수 num이 주어집니다.
        동일한 패리티(즉, 둘 다 홀수이거나 둘 다 짝수인 숫자)를 가진 num의 두 자릿수를 서로 교환할 수 있습니다.
        어떤 횟수의 교환 후에 가능한 num의 가장 큰 값을 반환하세요.
        [참고: 패리티(parity)란 숫자가 홀수인지 짝수인지를 나타내는 성질입니다.]

        Input: num = 1234
        Output: 3412
        Input: num = 65875
        Output: 87655

        숫자 8을 숫자 6과 교환하면, 85675가 됩니다.
        첫 번째 5를 숫자 7과 교환하면, 87655가 됩니다.
        다른 교환 순서가 있을 수 있지만, 87655가 가능한 가장 큰 수임을 알 수 있습니다.
     */

    public static int largestInteger(int num) {

        PriorityQueue<int[]> even = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        PriorityQueue<int[]> odd = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        String[] numsStrings = String.valueOf(num).split("");
        int[] nums = Arrays.stream(numsStrings).mapToInt(Integer::parseInt).toArray();

        List<Integer> res = new ArrayList<>(Collections.nCopies(nums.length, null));

        for (int i = 0; i < numsStrings.length; i++) {

            int n = Integer.parseInt(numsStrings[i]);
            if(n % 2 == 0) {
                even.add(new int[]{i, n});
                res.set(i,Integer.MAX_VALUE);
            } else {
                odd.add(new int[]{i, n});
                res.set(i,Integer.MIN_VALUE);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (Integer re : res) {

            if (re == Integer.MAX_VALUE) {
                ans.append(even.poll()[1]);
            } else {
                ans.append(odd.poll()[1]);
            }
        }

        return Integer.parseInt(ans.toString());

    }

    int largestInteger2(int num) {

        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());

        char[] chars = String.valueOf(num).toCharArray();
        boolean[] isEven = new boolean[chars.length]; // false로 초기화

        for (int i = 0; i < chars.length; i++) {
            int digit = chars[i] - '0';
            if (digit % 2 == 0) {
                even.add(digit);
                isEven[i] = true;
            } else {
                odd.add(digit);
            }
        }

        int res = 0;

        for (boolean b : isEven) {

            res = res * 10 + (b ? even.poll() : odd.poll());

        }

        return res;

    }
}
