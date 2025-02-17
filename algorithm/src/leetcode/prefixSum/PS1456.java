package leetcode.prefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class PS1456 {
    public int maxVowels(String s, int k) {

        Pattern p = Pattern.compile("[aeiou]");

        int len = s.length();
        int[] sums = new int[len];

        int sum = 0;

        for(int i = 0; i < len; i ++) {

            char c = s.charAt(i);
            if(p.matcher(String.valueOf(c)).matches()) {
                sum = sum + 1;
            }

            sums[i] = sum;

        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i <= len - k; i ++) {

            if(i == 0) {

                int kSum = sums[i + k - 1];
                max = Math.max(max,kSum);
            } else {
                int kSum = sums[i + k - 1] - sums[i - 1];
                max = Math.max(max, kSum);
            }
        }

        return max;

    }

    public int maxVowels2(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);

        int len = s.length();
        int[] sums = new int[len];

        int sum = 0;

        for(int i = 0; i < len; i ++) {

            char c = s.charAt(i);
            if(map.containsKey(c)) {
                sum = sum + 1;
            }

            sums[i] = sum;

        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i <= len - k; i ++) {

            if(i == 0) {

                int kSum = sums[i + k - 1];
                max = Math.max(max,kSum);
            } else {
                int kSum = sums[i + k - 1] - sums[i - 1];
                max = Math.max(max, kSum);
            }
        }

        return max;

    }
}
